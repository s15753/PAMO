package com.example.smartariumapp.ui.other;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.InputType;
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


public class WaterFragment extends Fragment {
    private int identifier = 4;
    private  Button bt_change, bt_refill, bt_send, bt_back;
    private String ammountString;
    private EditText amount;
    public WaterFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_water, container, false);
        final String title = getResources().getStringArray(R.array.other_main_strings)[identifier];
        amount = root.findViewById(R.id.amount);
        bt_change = root.findViewById(R.id.bt_change);
        bt_refill = root.findViewById(R.id.bt_refill);
        bt_send = root.findViewById(R.id.bt_send);
        bt_back = root.findViewById(R.id.bt_back);
        bt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_set_parameters(bt_change.getText().toString(), bt_refill.getText().toString(), root, title, "all");
            }
        });
        bt_refill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getVisibility() == View.GONE) {
                    amount.setVisibility(View.VISIBLE);
                    bt_send.setVisibility(View.VISIBLE);
                    bt_send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ammountString = amount.getText().toString();
                            if(ammountString.equals(null) || ammountString.isEmpty()){
                                Toast.makeText(getActivity(), "Nie podano ilości wymienionej wody!", Toast.LENGTH_SHORT).show();
                            }else{
                                check_set_parameters(bt_refill.getText().toString(), bt_change.getText().toString(), root, title, ammountString);
                            }
                        }
                    });
                }else {
                    amount.setVisibility(View.GONE);
                    bt_send.setVisibility(View.GONE);
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
    private void check_set_parameters(String ans, String other, View root, final String title, String val){
        if(DataHolder.isKeyIn(title+"_"+ans) || DataHolder.isKeyIn(title+"_"+other)){
            DataHolder.removeByKey(title+"_"+ans);
            DataHolder.removeByKey(title+"_"+other);
            Toast.makeText(getActivity(), "Usunięto " + title +" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{
            DataHolder.setMyData(title+"_"+ans, val);
            Toast.makeText(getActivity(), "Dodano "+ title + "_"+ ans + " do danych do wyałania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_other);

    }
}
