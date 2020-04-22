package com.example.smartariumapp.data.model;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.navigation.Navigation;

import com.example.smartariumapp.R;

public class MainButtonGenerator {
    private View root;
    private int identifier;
    public MainButtonGenerator(View root, int identifier){
        this.root = root;
        this.identifier = identifier;
    }
    public Button[] main_fragment_button(String[] myArray, int[] myColors){
        int n = myArray.length;
        Button[] myButtons = new Button[n];
        LinearLayout layout = this.root.findViewById(R.id.linearLayout);
        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext(), myArray, myColors);
            final int my_dest = setDestination(this.identifier, i);
            myButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(root).navigate(my_dest);
                }
            });

        }
        return myButtons;
    }

    private Button setMyButton(int i, Context context, String[] myArray, int[] myColors){
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
        }else {
            button.setBackgroundColor(myColors[i]);
        }
        return button;
    }

    private int setDestination(int identifier, int i) {
        switch (identifier) {
            case 0:
                switch (i){
                    case 0:
                        return R.id.action_nav_other_to_nav_other_filter;
                    case 1:
                        return R.id.action_nav_other_to_nav_other_light;
                    case 2:
                        return R.id.action_nav_other_to_nav_other_maintenance;
                    case 3:
                        return R.id.action_nav_other_to_nav_other_weight;
                    case 4:
                        return R.id.action_nav_other_to_nav_other_water;
                    case 5:
                        return R.id.action_nav_other_to_nav_other_bulb;

                }
            case 1:
                switch (i){
                    case 0:
                        return R.id.action_nav_water_parameters_to_nav_no3;
                    case 1:
                        return R.id.action_nav_water_parameters_to_nav_no2;
                    case 2:
                        return R.id.action_nav_water_parameters_to_nav_gh;
                    case 3:
                        return R.id.action_nav_water_parameters_to_nav_kh;
                    case 4:
                        return R.id.action_nav_water_parameters_to_nav_ph;
                    case 5:
                        return R.id.action_nav_water_parameters_to_nav_Cl;
                }
            case 2:
                switch (i) {
                    case 0:
                        return R.id.action_nav_food_to_nav_dry_food;
                    case 1:
                        return R.id.action_nav_food_to_nav_frozen_food;
                    case 2:
                        return R.id.action_nav_food_to_nav_other_food;
                }

        }
        return R.id.nav_home;
    }
}
