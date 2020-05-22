package com.example.smartariumapp.ui.home;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import com.example.smartariumapp.MainActivity;
import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.SendDataResponse;
import com.example.smartariumapp.data.model.pojo.TriggerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  Home fragment. Responsible for displaying alerts.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button bt_send;
    TextView data_to_send;
    ListView list ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        MainActivity activity = (MainActivity) getActivity();

        /*
        get token and username from MainActivity
        */
        Bundle bundleResult = activity.getLoginData();
        String token = bundleResult.getString("token");
        final String user = bundleResult.getString("userName");

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        data_to_send = root.findViewById(R.id.text_data_to_send);

        bt_send = root.findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                send user data to server
                */
                Call sendData = homeViewModel.sendDataInstance(user);
                sendData.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if (response.isSuccessful()) {
                            SendDataResponse zabbixResponse = (SendDataResponse) response.body();
                            Toast.makeText(getActivity(), zabbixResponse.getResponseMsg(),
                                                                        Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(getActivity(),
                                getString(R.string.send_data_error_msg) + response.code(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                DataHolder.removeAll();
                Navigation.findNavController(root).navigate(R.id.nav_home);
            }
        });

        /*
        display data or hide layout
        */
        if(DataHolder.checkLength() == 0){
            root.findViewById(R.id.send_values_display).setVisibility(View.GONE);
        }else{
            data_to_send.setText(DataHolder.myDataToString());
        }

        Call getAlerts= homeViewModel.getAlertInstance(token);

        /*
        get alerts using Rest request
         */
        getAlerts.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    TriggerResponse triggerResponse = (TriggerResponse) response.body();

                    if(triggerResponse.isResultSet()) {
                        root.findViewById(R.id.trigger_values_display).setVisibility(View.VISIBLE);

                        /*
                        set alerts in ListView
                         */
                        list = (ListView) root.findViewById(R.id.triggerView);
                        TriggerAdapter triggerAdapter = new TriggerAdapter(root.getContext(), triggerResponse.getResult());
                        list.setAdapter(triggerAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


}
