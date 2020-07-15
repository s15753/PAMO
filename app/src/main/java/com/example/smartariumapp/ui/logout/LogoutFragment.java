package com.example.smartariumapp.ui.logout;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.MainActivity;
import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.LogoutResponse;
import com.example.smartariumapp.ui.home.HomeViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoutFragment extends Fragment {
    TextView logout_text;
    private HomeViewModel homeViewModel;
    Handler handlerUI = new Handler();

    public static LogoutFragment newInstance() {
        return new LogoutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        final MainActivity activity = (MainActivity) getActivity();

        /*
        get token and username from MainActivity
        */
        Bundle bundleResult = activity.getLoginData();
        final String token = bundleResult.getString("token");
        final String user = bundleResult.getString("userName");

        final View root = inflater.inflate(R.layout.logout_fragment, container, false);

        logout_text = (TextView) root.findViewById(R.id.logout_text);
        logout_text.setTextSize(30);
        logout_text.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        /*
        logout user
        */
        Call sendData = homeViewModel.logoutInstance(token);
        sendData.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    LogoutResponse logoutResponse = (LogoutResponse) response.body();

                    if (logoutResponse.isResultSet()) {
                        logout_text.setText(R.string.correct_logout);
                        handlerUI.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                DataHolder.removeAll();
                                activity.finishAffinity();
                                System.exit(0);
                            }
                        }, 1500);
                    } else {
                        logout_text.setText(logoutResponse.getErrorData());
                        handlerUI.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getFragmentManager().popBackStackImmediate();
                            }
                        }, 2000);
                    }
                } else {
                    logout_text.setText(R.string.send_data_error_msg + response.code());
                    handlerUI.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getFragmentManager().popBackStackImmediate();
                        }
                    }, 2000);
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