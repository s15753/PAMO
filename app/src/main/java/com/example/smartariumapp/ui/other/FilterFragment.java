package com.example.smartariumapp.ui.other;

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

import com.example.smartariumapp.*;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

/**
 * Fragment for filter.
 *
 * This fragment is used to notice actions performed by user concern filter in monitored tank.
 * User can replace or change filter element
 * If action is chosen twice instead of adding it to data to send we remove it from that list.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class FilterFragment extends Fragment {
    private int identifier = 0;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;
    private Button bt_back;

    public FilterFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_filter, container, false);
        final TextView textView = root.findViewById(R.id.text_filter);
        final String title = getResources().getStringArray(R.array.other_main_strings)[identifier];
        textView.setText(title);
        final LinearLayout layout = root.findViewById(R.id.linearLayout);
        myArray = getResources().getStringArray(R.array.filter_strings);
        myColors = getResources().getIntArray(R.array.water_parameters_colors);
        int n = myArray.length;
        myButtons = new Button[n];

        for(int i = 0; i < 2; i++){
            myButtons[i] = setMyButton(i, layout.getContext());
            final int key_val = i;
            final String main_button_string = myArray[i];
            myButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myButtons[1 - key_val].setVisibility(View.INVISIBLE);
                   if (myButtons[2] == null) {
                       for(int k = 2; k < myArray.length; k++){
                          myButtons[k] = setMyButton(k, layout.getContext());
                          final int value = k;
                          myButtons[k].setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  check_set_parameters(key_val, root, value);
                              }
                          });
                           layout.addView(myButtons[k]);
                       }
                   }else{
                       myButtons[1 - key_val].setVisibility(View.VISIBLE);
                       for(int k = 2; k < myArray.length; k++){
                           layout.removeView(myButtons[k]);
                           myButtons[k] = null;

                       }
                    }
                }

            });
            layout.addView(myButtons[i]);
        }
        bt_back = setMyButton(myArray.length, layout.getContext());
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_other);
            }
        });
        layout.addView(bt_back);
        return root;
    }

    /**
     * Auxiliary method used to define actions caused by onclick action.
     *
     *
     * @param value parameter that we set (part of a filter)
     * @param key_val action that is performed on parameter (0 - clean, 1 - replace)
     * @param root current View
     */
    private void check_set_parameters(int key_val, View root, int value){
        if(DataHolder.isKeyIn(myArray[value])){
            DataHolder.removeByKey(myArray[value]);
            Toast.makeText(getActivity(), "Usunięto " + myArray[value] + " "+ myArray[key_val] +" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{
            DataHolder.setMyData(myArray[value], new ZabbixData("Filtr", key_val != 1 ? "clean":"replace", ""+(value-1) ));
            Toast.makeText(getActivity(), "Dodano "+ myArray[value] + " "+ myArray[key_val] + " do danych do wyałania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_other);

    }
    /**
     * Auxiliary method use to create Button witch values base on button index in list
     *
     * @param i index of button which is base to select appropriate values of text and color
     * @param context context concern our fragment
     * @return Partially functional button without working on-click listener
     */
    private Button setMyButton(int i, Context context){
        Button button = new Button(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);
        button.setLayoutParams(params);
        final String ans;
        if(i == this.myArray.length){
            ans = getResources().getString(R.string.back);
            button.setText(ans);
            button.setBackgroundColor(getResources().getColor(R.color.back));

        }else {
            ans = this.myArray[i];
            button.setText(ans);
            button.setBackgroundColor(this.myColors[i]);
        }
        return button;
    }

}
