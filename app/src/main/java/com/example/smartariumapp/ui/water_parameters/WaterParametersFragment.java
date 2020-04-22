package com.example.smartariumapp.ui.water_parameters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.model.ButtonGenerator;

public class WaterParametersFragment extends Fragment {

    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    private int identifier = 1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_water_parameters, container, false);
        final TextView textView = root.findViewById(R.id.text_water_parameter);

        textView.setText(R.string.water_string);

        LinearLayout layout = root.findViewById(R.id.linearLayout);
        ButtonGenerator buttonGenerator = new ButtonGenerator(root, identifier);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        myArray = getResources().getStringArray(R.array.water_param_strings);
        myButtons = buttonGenerator.main_fragment_button(myArray, myColors);
        for(Button button: myButtons){
            layout.addView(button);
        }
        return root;
    }

}
