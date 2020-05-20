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
 * Auxiliary class simplifying creation of long list of buttons use to gather data concerning food.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class LeafFoodFragmentButtonGenerator {
    private View root;
    private Activity activity;

    /**
     * Public constructor
     *
     * @param root View on which created buttons will be display
     * @param activity FragmentActivity to show response to user actions
     * @return Construct instance of LeafFoodFragmentButtonGenerator
     */
    public LeafFoodFragmentButtonGenerator(View root, FragmentActivity activity){
        this.root = root;
        this.activity = activity;
    }
    /**
     * Method creating list of buttons that will be visible on one of the food fragments
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
                    check_set_parameters(ans);
                }
            });
        }
        return button;
    }
    /**
     * Auxiliary method used to define actions caused by onclick action
     *
     * @param ans text visible on the button
     */
    private void check_set_parameters(String ans){
        if(DataHolder.isKeyIn(ans)){
            DataHolder.removeByKey(ans);
            Toast.makeText(activity, "Usunięto "+ans+" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{
            String[] myFoodNames = root.getResources().getStringArray(R.array.food_zabbix_name);
            int counter = 0;
            for (int i = 0; i < myFoodNames.length; i++){
                if (myFoodNames[i].equalsIgnoreCase(ans)){
                    counter = i + 1;
                    break;
                }
            }
            DataHolder.setMyData(ans, new ZabbixData("Jedzenie", "food", ""+counter));
            Toast.makeText(activity, "Dodano "+ ans + " do danych do wyałania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_food);
    }
}
