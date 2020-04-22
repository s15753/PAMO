package com.example.smartariumapp.ui.water_parameters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.smartariumapp.R;
import com.example.smartariumapp.data.model.LeafWaterFragmentButtonGenerator;

public class NO3Fragment extends Fragment {

    private int identifier = 0;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_water_parameters, container, false);
        final TextView textView = root.findViewById(R.id.text_water_parameter);
        final String parameter = getResources().getStringArray(R.array.water_param_strings_zabbix_items)[identifier];
        textView.setText(parameter);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myColors = getResources().getIntArray(R.array.no3_colors);
        myArray = getResources().getStringArray(R.array.water_param_values_NO3);
        LeafWaterFragmentButtonGenerator leafWaterFragmentButtonGenerator = new LeafWaterFragmentButtonGenerator(root, identifier, getActivity(), parameter);
        myButtons = leafWaterFragmentButtonGenerator.leafFragmentButton(myArray, myColors);
        for(Button button : myButtons){
            layout.addView(button);
        }
        return root;
    }
}
