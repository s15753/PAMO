package com.example.smartariumapp.ui.food;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class FoodFragment extends Fragment {

    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.food_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_food);

        textView.setText(R.string.food_text);

        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myColors = getResources().getIntArray(R.array.food_colors);
        myArray = getResources().getStringArray(R.array.food_main_strings);
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
                return R.id.action_nav_food_to_nav_dry_food;
            case 1:
                return R.id.action_nav_food_to_nav_frozen_food;
            case 2:
                return R.id.action_nav_food_to_nav_other_food;
        }
        return R.id.nav_home;
    }

}
