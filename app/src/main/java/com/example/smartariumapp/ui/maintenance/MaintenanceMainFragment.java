package com.example.smartariumapp.ui.maintenance;

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
import com.example.smartariumapp.data.model.MainButtonGenerator;

/**
 * Main fragment for maintenance parameters.
 * It allows user to navigate to one of other category like light or maintenance
 *
 * This fragment use fragment_maintenance_main.xml layout and MainButtonGenerator to generate appropriate buttons.
 *
 * Resources:
 * water_parameters_colors
 * maintenance_main_strings
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class MaintenanceMainFragment extends Fragment {
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    private int identifier = 3;

    public MaintenanceMainFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_maintenance_main, container, false);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        MainButtonGenerator mainButtonGenerator = new MainButtonGenerator(root, identifier);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        myArray = getResources().getStringArray(R.array.maintenance_main_strings);
        myButtons = mainButtonGenerator.main_fragment_button(myArray,myColors);
        for(Button button: myButtons){
            layout.addView(button);
        }
        return root;
    }
}
