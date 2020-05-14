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

import java.util.Map;

public class LeafFoodFragmentButtonGenerator {
    private View root;
    private Activity activity;
    private final String parameter;

    public LeafFoodFragmentButtonGenerator(View root, FragmentActivity activity, String parameter){
        this.root = root;
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
                    check_set_parameters(ans);
                }
            });
        }
        return button;
    }

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
