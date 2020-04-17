package com.example.smartariumapp.ui.water_parameters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;



public class KHFragment extends Fragment {
    private WaterParametersViewModel waterParametersViewModel;
    private int identifier = 3;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_water_parameters, container, false);
        final TextView textView = root.findViewById(R.id.text_water_parameter);
        final String parameter = getResources().getStringArray(R.array.water_param_strings_zabbix_items)[identifier];
        textView.setText(parameter);
        LinearLayout layout = root.findViewById(R.id.water_layout);
        myColors = getResources().getIntArray(R.array.kh_colors);
        myArray = getResources().getStringArray(R.array.water_param_values_KH);
        int n = myArray.length;
        myButtons = new Button[n];

        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext());
            final String ans = myArray[i];
            myButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(parameter, ans, root);
                }
            });
            layout.addView(myButtons[i]);
        }

        return root;
    }

    private void check_set_parameters(String parameter, String ans, View root){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_water_parameters);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(parameter, ans);
            Toast.makeText(getActivity(), parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.action_nav_kh_to_nav_pH);
        }

    }
    private Button setMyButton(int i, Context context){
        Button button = new Button(context);
        button.setBackgroundColor(this.myColors[i]);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);
        button.setLayoutParams(params);
        button.setText(this.myArray[i]);
        return button;

    }

}


