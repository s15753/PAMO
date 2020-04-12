package com.example.smartariumapp.ui.water_parameters;

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
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class GHFragment extends Fragment {

    private WaterParametersViewModel waterParametersViewModel;
    private int identifier = 2;
    private Button[] buttons;
    private Button btn_GH_none;
    String[] my_Array;

    public static GHFragment newInstance() {
        return new GHFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        waterParametersViewModel =
                ViewModelProviders.of(this).get(WaterParametersViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gh, container, false);
        final TextView textView = root.findViewById(R.id.text_twardosc);
        waterParametersViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        my_Array = getResources().getStringArray(R.array.water_param_values_GH);
        buttons = new Button[5];
        buttons[0] = root.findViewById(R.id.bt_GH_3);
        buttons[1] = root.findViewById(R.id.bt_GH_4);
        buttons[2] = root.findViewById(R.id.bt_GH_7);
        buttons[3] = root.findViewById(R.id.bt_GH_14);
        buttons[4] = root.findViewById(R.id.bt_GH_21);

        btn_GH_none = root.findViewById(R.id.bt_lack_of_data);
        int n = buttons.length;

        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i] + " d");
            final String my_text = my_Array[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(my_text, root, waterParametersViewModel, identifier);
                }
            });
        }
        btn_GH_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_nav_gh_to_nav_kh);
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
            Navigation.findNavController(root).navigate(R.id.action_nav_gh_to_nav_kh);
        }

    }

}
