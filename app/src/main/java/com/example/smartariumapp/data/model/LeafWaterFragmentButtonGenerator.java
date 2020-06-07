package com.example.smartariumapp.data.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import com.example.smartariumapp.*;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;


/**
 * Auxiliary class simplifying creation of long list of buttons use to gather data concerning water parameters.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class LeafWaterFragmentButtonGenerator {
    private View root;
    private int identifier;
    private Activity activity;
    private final String parameter;

    /**
     * Public constructor
     *
     * @param root View on which created buttons will be display
     * @param identifier value use to determent suitable course of action
     * @param activity FragmentActivity to show response to user actions
     * @param parameter key set to identify this element in in DataHolder.
     */
    public LeafWaterFragmentButtonGenerator(View root, int identifier, FragmentActivity activity, String parameter){
        this.root = root;
        this.identifier = identifier;
        this.activity = activity;
        this.parameter = parameter;
    }

    /**
     * Method creating list of buttons that will be visible on one of the water parameters fragments
     *
     * @param myArray array of strings use to create button in certain text
     * @param myColors array of strings use to create button witch certain background color
     * @return Fully functional list of buttons
     */
    public Button[] leafFragmentButton(String[] myArray, int[] myColors){
        int n = myArray.length;
        Button[] myButtons = new Button[n];
        LinearLayout layout = this.root.findViewById(R.id.linearLayout);
        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext(), myArray, myColors);
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
    /**
     * Auxiliary method used to define actions caused by onclick action
     *
     * @param parameter parameter that we set
     * @param ans text visible on the button (value for this water parameter)
     */
    private void check_water_set_parameters(String parameter, String ans){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(this.activity, "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_water_parameters);
        }else{
            DataHolder.setMyData(parameter, new ZabbixData("Woda", parameter.toUpperCase(), ans));
            Toast.makeText(this.activity, parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(setDestination(this.identifier));
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    /**
     * Auxiliary method used to define destination caused by onclick action
     *
     * @param identifier value use to determent suitable course of action
     */
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
