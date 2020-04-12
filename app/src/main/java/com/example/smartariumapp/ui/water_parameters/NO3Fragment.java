package com.example.smartariumapp.ui.water_parameters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import androidx.navigation.Navigation;


import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class NO3Fragment extends Fragment {

    private WaterParametersViewModel waterParametersViewModel;
    private int identifier = 0;
    private Button[] buttons;
    private Button btn_NO3_none;
    String[] my_Array;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        waterParametersViewModel =
                ViewModelProviders.of(this).get(WaterParametersViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_no3, container, false);
        final TextView textView = root.findViewById(R.id.text_no3);

        my_Array = getResources().getStringArray(R.array.water_param_values_NO3);
        waterParametersViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        buttons = new Button[7];
        buttons[0] = root.findViewById(R.id.bt_NO3_0);
        buttons[1] = root.findViewById(R.id.bt_NO3_10);
        buttons[2] = root.findViewById(R.id.bt_NO3_25);
        buttons[3] = root.findViewById(R.id.bt_NO3_50);
        buttons[4] = root.findViewById(R.id.bt_NO3_100);
        buttons[5] = root.findViewById(R.id.bt_NO3_250);
        buttons[6] = root.findViewById(R.id.bt_NO3_500);
        btn_NO3_none = root.findViewById(R.id.bt_lack_of_data);
        int n = buttons.length;
        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i] + " mg/l");
            final String my_text = my_Array[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(my_text, root, waterParametersViewModel, identifier);
                }
            });
        }
        btn_NO3_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_nav_no3_to_nav_no2);
            }
        });

        return root;
    }

    private void check_set_parameters(String ans, View root, WaterParametersViewModel waterParametersViewModel, int identifier){
        if(DataHolder.isKeyIn(waterParametersViewModel.mListText.get(identifier))){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_home);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(waterParametersViewModel.mListText.get(identifier), ans);
            Toast.makeText(getActivity(), waterParametersViewModel.mListText.get(identifier)+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.action_nav_no3_to_nav_no2);
        }

    }

}
