package com.example.smartariumapp.ui.other;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.smartariumapp.R;

public class OtherFragment extends Fragment {


    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_other, container, false);
        final TextView textView = root.findViewById(R.id.text_other);

        textView.setText(R.string.text_other);

        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        myArray = getResources().getStringArray(R.array.other_main_strings);
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

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);
        button.setLayoutParams(params);
        button.setText(this.myArray[i]);
        if(this.myArray.length - 1 == i){
            button.setBackgroundColor(getResources().getColor(R.color.back));
        }else {
            button.setBackgroundColor(this.myColors[i]);
        }
        return button;

    }
    private int setDestination(int i){
        switch (i){
            case 0:
                return R.id.action_nav_other_to_nav_other_filter;
            case 1:
                return R.id.action_nav_other_to_nav_other_light;
            case 2:
                return R.id.action_nav_other_to_nav_other_maintenance;
            case 3:
                return R.id.action_nav_other_to_nav_other_weight;
            case 4:
                return R.id.action_nav_other_to_nav_other_water;
            case 5:
                return R.id.action_nav_other_to_nav_other_bulb;
            default:
                return R.id.nav_home;
        }
    }
}
