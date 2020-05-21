package com.example.smartariumapp.ui.water_parameters;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

/**
 * Fragment allowing user to choose value for GH water parameter
 * This parameter can occur only once in gathered data before send (only one value allowed)
 *
 * This fragment use fragment_gh.xml layout. 
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class GHFragment extends Fragment {

    private int identifier = 2;
    private Button[] buttons;
    private Button btn_GH_back;
    String[] my_Array;

    public static GHFragment newInstance() {
        return new GHFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_gh, container, false);
        final String parameter = getResources().getStringArray(R.array.water_param_strings_zabbix_items)[identifier];
        final TextView textView = root.findViewById(R.id.text_GH);
        textView.setText(parameter);

        my_Array = getResources().getStringArray(R.array.water_param_values_GH);
        buttons = new Button[5];
        buttons[0] = root.findViewById(R.id.bt_GH_3);
        buttons[1] = root.findViewById(R.id.bt_GH_4);
        buttons[2] = root.findViewById(R.id.bt_GH_7);
        buttons[3] = root.findViewById(R.id.bt_GH_14);
        buttons[4] = root.findViewById(R.id.bt_GH_21);

        btn_GH_back = root.findViewById(R.id.bt_lack_of_data);
        int n = buttons.length;

        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i] + " d");
            final String my_text = my_Array[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(my_text, root, parameter);
                }
            });
        }
        btn_GH_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_water_parameters);
            }
        });
        return root;
    }
    /**
     * Auxiliary method used to define actions caused by onclick action
     *
     * @param parameter parameter that we set
     * @param ans text visible on the button (value for this water parameter)
     */
    private void check_set_parameters(String ans, View root, final String parameter){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_home);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(parameter, new ZabbixData("Woda", parameter.toUpperCase(), ans));
            Toast.makeText(getActivity(), parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.action_nav_gh_to_nav_kh);
        }

    }

}
