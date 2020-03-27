package com.example.smartariumapp.ui.gallery;

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

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

public class NO2Fragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private int identifier = 1;
    private Button btn_NO2_0, btn_NO2_0_5, btn_NO2_2, btn_NO2_5, btn_NO2_10, btn_NO2_none;
    public static NO2Fragment newInstance() {
        return new NO2Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.n_o2_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_no2);
        galleryViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        btn_NO2_0 = root.findViewById(R.id.bt_NO2_0);
        btn_NO2_0_5 = root.findViewById(R.id.bt_NO2_0_5);
        btn_NO2_2 = root.findViewById(R.id.bt_NO2_2);
        btn_NO2_5 = root.findViewById(R.id.bt_NO2_5);
        btn_NO2_10 = root.findViewById(R.id.bt_NO2_10);
        btn_NO2_none = root.findViewById(R.id.bt_lack_of_data);
        btn_NO2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "0");
                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        btn_NO2_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "0.5");
                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        btn_NO2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "2");
                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        btn_NO2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "5");
                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        btn_NO2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "10");
                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        btn_NO2_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(root).navigate(R.id.action_nav_no2fragment_to_nav_twardosc);
            }
        });
        return root;

    }

}
