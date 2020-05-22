package com.example.smartariumapp.ui.food;

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
 * Main fragment for food.
 * It allows user to navigate to one of food category like dry or frozen
 *
 * This fragment use food_fragment.xml layout and MainButtonGenerator to generate appropriate buttons.
 *
 * Resources:
 * food_colors
 * food_main_strings
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class FoodFragment extends Fragment {

    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    private int identifier = 2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.food_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_food);
        textView.setText(R.string.food_text);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        MainButtonGenerator mainButtonGenerator = new MainButtonGenerator(root, identifier);
        myColors = getResources().getIntArray(R.array.food_colors);
        myArray = getResources().getStringArray(R.array.food_main_strings);
        myButtons = mainButtonGenerator.main_fragment_button(myArray,myColors);
        for(Button button: myButtons){
           layout.addView(button);
        }
        return root;
    }
}
