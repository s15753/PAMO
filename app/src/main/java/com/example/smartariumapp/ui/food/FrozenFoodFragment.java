package com.example.smartariumapp.ui.food;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
import com.example.smartariumapp.data.model.LeafFoodFragmentButtonGenerator;


public class FrozenFoodFragment extends Fragment {
    private int identifier = 1;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;


    public FrozenFoodFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.food_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_food);
        final String title = getResources().getStringArray(R.array.food_main_strings)[identifier];
        textView.setText(title);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myArray = getResources().getStringArray(R.array.food_frozen_strings);
        myColors = getResources().getIntArray(R.array.food_colors);
        LeafFoodFragmentButtonGenerator leafFoodFragmentButtonGenerator = new LeafFoodFragmentButtonGenerator(root, getActivity(),title);
        myButtons = leafFoodFragmentButtonGenerator.leafFragmentButton(myArray, myColors);
        for(Button button : myButtons){
            layout.addView(button);
        }
        return root;
    }
}
