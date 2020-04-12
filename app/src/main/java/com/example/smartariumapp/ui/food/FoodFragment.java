package com.example.smartariumapp.ui.food;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class FoodFragment extends Fragment {

    private FoodViewModel foodViewModel;
    private Button[] buttons;
    String[] my_Array;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        foodViewModel =
                ViewModelProviders.of(this).get(FoodViewModel.class);
        final View root = inflater.inflate(R.layout.food_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_food);
        foodViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        my_Array = getResources().getStringArray(R.array.food_main_strings);
        int n = my_Array.length;
        buttons = new Button[n];
        buttons[0] = root.findViewById(R.id.bt_food_0);
        buttons[1] = root.findViewById(R.id.bt_food_1);
        buttons[2] = root.findViewById(R.id.bt_food_2);
        buttons[3] =root.findViewById(R.id.bt_back);

        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i]);
            final int nav_to = setDestination(i);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(root).navigate(nav_to);
                }
            });
        }
        return root;
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
