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

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

public class BulbFragment extends Fragment {
    private int identifier = 5;
    private Button[] myButtons;
    private String[] myArray;
    private int[] myColors;

    public BulbFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_other, container, false);
        final TextView textView = root.findViewById(R.id.text_other);
        final String title = getResources().getStringArray(R.array.other_main_strings)[identifier];
        textView.setText(title);
        LinearLayout layout = root.findViewById(R.id.linearLayout);
        myArray = getResources().getStringArray(R.array.bulb_strings);
        myColors = getResources().getIntArray(R.array.food_colors);
        int n = myArray.length;

        myButtons = new Button[n];

        for(int i = 0; i < n; i++){
            myButtons[i] = setMyButton(i, layout.getContext(), root, title);
            layout.addView(myButtons[i]);
        }

        return root;
    }
    private void check_set_parameters(String ans, View root, String title){
        if(DataHolder.isKeyIn(title)){
            DataHolder.removeByKey(title);
            Toast.makeText(getActivity(), "Usunięto " + title + " "+ ans +" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{

            DataHolder.setMyData(title, new ZabbixData("Oswietlenie", "replace", "1"));
            Toast.makeText(getActivity(), "Dodano "+ title + " "+ ans + " do danych do wyałania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_other);

    }
    private Button setMyButton(int i, Context context, final View root, final  String title){
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
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(root).navigate(R.id.nav_other);
                }
            });
        }else {
            button.setBackgroundColor(this.myColors[i]);
            final String ans = myArray[i];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(ans, root, title);
                }
            });
        }
        return button;
    }

}
