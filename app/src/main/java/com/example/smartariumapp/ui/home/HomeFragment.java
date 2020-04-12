package com.example.smartariumapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button bt_send;
    TextView data_to_send;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        data_to_send = root.findViewById(R.id.text_data_to_send);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        bt_send = root.findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.removeAll();
                Navigation.findNavController(root).navigate(R.id.nav_home);
            }
        });

        if(DataHolder.checkLength() == 0){
            bt_send.setVisibility(View.INVISIBLE);
        }else{
            data_to_send.setText(DataHolder.myDataToString());
        }

        return root;
    }
}
