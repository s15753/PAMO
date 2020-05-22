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
import com.example.smartariumapp.data.model.LeafFoodFragmentButtonGenerator;



/**
 * Fragment allowing user to choose from food kinds that didn't match other categories.
 * There can be more then one kind of food chosen but each food can be choose only once.
 * So if food is chosen twice instead of adding it to data to send we remove it from that list.
 *
 * This fragment use food_fragment.xml layout and LeafFoodFragmentButtonGenerator to generate appropriate buttons.
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class OtherFoodFragment extends Fragment {
    private int identifier = 2;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;

    public OtherFoodFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.food_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_food);
        final String title = getResources().getStringArray(R.array.food_main_strings)[identifier];
        textView.setText(title);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myArray = getResources().getStringArray(R.array.food_other_strings);
        myColors = getResources().getIntArray(R.array.food_colors);
        LeafFoodFragmentButtonGenerator leafFoodFragmentButtonGenerator = new LeafFoodFragmentButtonGenerator(root, getActivity());
        myButtons = leafFoodFragmentButtonGenerator.leafFragmentButton(myArray, myColors);
        for(Button button : myButtons){
            layout.addView(button);
        }
        return root;
    }
}
