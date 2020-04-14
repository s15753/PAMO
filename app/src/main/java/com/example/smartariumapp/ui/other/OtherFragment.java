package com.example.smartariumapp.ui.other;

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


    private Button[] buttons;
    private String[] my_Array;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_other, container, false);
        LinearLayout myLinearLayout = root.findViewById(R.id.linearLayout);
        my_Array = getResources().getStringArray(R.array.other_main_strings);
        int counter = 0;
        int n = my_Array.length - 1;
        buttons = new Button[my_Array.length + 1];
        for(int i = 0; i < myLinearLayout.getChildCount(); i++){
            final View v = myLinearLayout.getChildAt(i);
            if(v instanceof TextView){
                ((TextView) v).setText(getResources().getText(R.string.other));
            }
            if(v instanceof Button){
                if(counter <= n) {
                    buttons[counter] = (Button)v;
                    buttons[counter].setText(my_Array[counter]);
                    final int nav_to = setDestination(counter);
                    buttons[counter].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Navigation.findNavController(root).navigate(nav_to);
                        }
                    });

                    counter++;
                }else{
                    buttons[counter] = (Button)v;
                    buttons[counter].setText(getResources().getText(R.string.back));
                    final int nav_to = setDestination(counter);
                    buttons[counter].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Navigation.findNavController(root).navigate(nav_to);
                        }
                    });
                }
            }

        }
        return root;
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
