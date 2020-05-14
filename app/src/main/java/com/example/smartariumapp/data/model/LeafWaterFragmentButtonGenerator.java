package com.example.smartariumapp.data.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

public class LeafWaterFragmentButtonGenerator {
    private View root;
    private int identifier;
    private Activity activity;
    private final String parameter;

    public LeafWaterFragmentButtonGenerator(View root, int identifier, FragmentActivity activity, String parameter){
        this.root = root;
        this.identifier = identifier;
        this.activity = activity;
        this.parameter = parameter;
    }

    public Button[] leafFragmentButton(String[] myArray, int[] myColors){
        int n = myArray.length;
        Button[] myButtons = new Button[n];
        LinearLayout layout = this.root.findViewById(R.id.linearLayout);
        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext(), myArray, myColors);
        }
        return myButtons;
    }
    private Button setMyButton(int i, Context context, final String[] myArray, int[] myColors){
        Button button = new Button(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);
        button.setLayoutParams(params);
        button.setText(myArray[i]);
        if(myArray.length - 1 == i){
            button.setBackgroundColor(context.getResources().getColor(R.color.back));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(root).navigate(R.id.nav_water_parameters);
                }
            });
        }else {
            button.setBackgroundColor(myColors[i]);
            final String ans = myArray[i];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_water_set_parameters(parameter, ans);
                }
            });
        }
        return button;
    }
    private void check_water_set_parameters(String parameter, String ans){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(this.activity, "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_water_parameters);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(parameter, new ZabbixData("Woda", parameter.toUpperCase(), ans));
            Toast.makeText(this.activity, parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(setDestination(this.identifier));
        }
    }

    private int setDestination(int identifier) {
        switch (identifier) {
            case 0:
                return R.id.action_nav_no3_to_nav_no2;
            case 1:
                return R.id.action_nav_no2_to_nav_gh;
            case 3:
                return R.id.action_nav_kh_to_nav_pH;
            case 4:
                return R.id.action_nav_pH_to_nav_Cl;
            case 5:
                return R.id.nav_water_parameters;
            }
        return R.id.nav_home;
    }
}
