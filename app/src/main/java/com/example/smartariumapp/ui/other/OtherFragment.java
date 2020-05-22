package com.example.smartariumapp.ui.other;

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
import com.example.smartariumapp.data.model.MainButtonGenerator;


/**
 * Main fragment for other parameters.
 * It allows user to navigate to one of other category like bulb or filter
 *
 * This fragment use fragment_other.xml layout and MainButtonGenerator to generate appropriate buttons.
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class OtherFragment extends Fragment {


    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    private int identifier = 0;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_other, container, false);
        final TextView textView = root.findViewById(R.id.text_other);
        MainButtonGenerator mainButtonGenerator = new MainButtonGenerator(root, this.identifier);
        textView.setText(R.string.text_other);

        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        myArray = getResources().getStringArray(R.array.other_main_strings);
        myButtons = mainButtonGenerator.main_fragment_button(myArray, myColors);
        for(Button button: myButtons){
            layout.addView(button);
        }
        return root;
    }

}
