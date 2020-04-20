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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;


public class WeightFragment extends Fragment {
    private int identifier = 3;
    private Button bt_back, bt_send;
    private String massString1, massString2;
    private EditText mass1, mass2;
    public WeightFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_weight, container, false);
        final TextView textView = root.findViewById(R.id.text_weight);
        final String title = getResources().getStringArray(R.array.other_main_strings)[identifier];
        textView.setText(title);
        bt_back = root.findViewById(R.id.bt_back);
        bt_send = root.findViewById(R.id.bt_send);
        mass1 = root.findViewById(R.id.matilda_mass);
        mass2 = root.findViewById(R.id.stefanie_mass);

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                massString1 = mass1.getText().toString();
                massString2 = mass2.getText().toString();
                if(massString1.isEmpty() && massString2.isEmpty()){
                    Toast.makeText(getActivity(), "Nie podano wagi zwierzaków!", Toast.LENGTH_SHORT).show();
                }else {
                    if (!massString1.isEmpty()) {
                        check_set_parameters(getResources().getString(R.string.matilda), massString1, root);
                    }
                    if (!massString2.isEmpty()) {
                        check_set_parameters(getResources().getString(R.string.stefanie), massString2, root);
                    }
                }
            }
        });

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_other);
            }
        });
        return root;
    }
    private void check_set_parameters(String parameter, String ans, View root){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_other);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(parameter, ans);
            Toast.makeText(getActivity(), parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_other);
        }

    }
}
