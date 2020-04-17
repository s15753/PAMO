package com.example.smartariumapp.ui.water_parameters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
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

public class WaterParametersFragment extends Fragment {

    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_water_parameters, container, false);
        final TextView textView = root.findViewById(R.id.text_water_parameter);

        textView.setText(R.string.water_string);

        LinearLayout layout = root.findViewById(R.id.water_layout);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        myArray = getResources().getStringArray(R.array.water_param_strings);
        int n = myArray.length;
        myButtons = new Button[n];

        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext());
            final int my_dest = setDestination(i);
            myButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(root).navigate(my_dest);
                }
            });
            layout.addView(myButtons[i]);
        }

        return root;
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
    private int setDestination(int i){
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
            default:
                return R.id.action_nav_water_parameters_to_nav_home;
        }
    }
}
