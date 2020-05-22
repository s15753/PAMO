package com.example.smartariumapp.data.model;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.navigation.Navigation;

import com.example.smartariumapp.*;


/**
 * Auxiliary class simplifying creation of long list of buttons allow users to navigate through
 *  main fragments like food or water parameters and gather suitable data.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class MainButtonGenerator {
    private View root;
    private int identifier;
    /**
     * Public constructor
     *
     * @param root View on which created buttons will be display
     * @param identifier value use to determent fragment we are in and suitable course of action.
     */
    public MainButtonGenerator(View root, int identifier){
        this.root = root;
        this.identifier = identifier;
    }

    /**
     * Method creating list of buttons that will be visible on one of the food fragments
     *
     * @param myArray array of strings use to create button in certain text
     * @param myColors array of strings use to create button witch certain background color
     * @return Fully functional list of buttons
     */
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

    /**
     * Auxiliary method use to create Button witch values base on button index in list
     *
     * @param i index of button which is base to select appropriate values of text and color
     * @param context context concern our fragment
     * @param myArray array of strings use to create button witch certain text
     * @param myColors array of strings use to create button witch certain background color
     * @return Fully functional button with working on-click listener
     */
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
    /**
     * Auxiliary method used to define actions caused by onclick action
     *
     * @param identifier value use to determent fragment we are in and suitable course of action.
     * @param i button identification use to determent destination fragment
     */
    private int setDestination(int identifier, int i) {
        switch (identifier) {
            case 0:
                switch (i){
                    case 0:
                        return R.id.action_nav_other_to_nav_other_filter;
                    case 1:
                        return R.id.action_nav_other_to_nav_other_weight;
                    case 2:
                        return R.id.action_nav_other_to_nav_other_water;
                    case 3:
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
            case 3:
                switch (i){
                    case 0:
                        return R.id.action_nav_maintenance_main_to_nav_light;
                    case 1:
                        return R.id.action_nav_maintenance_main_to_nav_maintenance;
                }
        }
        return R.id.nav_home;
    }
}
