package com.example.smartariumapp.ui.gallery;

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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private int identifier = 0;
    private String ans;
    private Button btn_NO3_0, btn_NO3_10, btn_NO3_25, btn_NO3_50, btn_NO3_100, btn_NO3_250, btn_NO3_500, btn_NO3_none;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_no3);
        galleryViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        btn_NO3_0 = root.findViewById(R.id.bt_NO3_0);
        btn_NO3_10 = root.findViewById(R.id.bt_NO3_10);
        btn_NO3_25 = root.findViewById(R.id.bt_NO3_25);
        btn_NO3_50 = root.findViewById(R.id.bt_NO3_50);
        btn_NO3_100 = root.findViewById(R.id.bt_NO3_100);
        btn_NO3_250 = root.findViewById(R.id.bt_NO3_250);
        btn_NO3_500 = root.findViewById(R.id.bt_NO3_500);
        btn_NO3_none = root.findViewById(R.id.bt_lack_of_data);

        btn_NO3_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "0");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "10");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "25");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "50");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "100");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "250");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHolder.setMyData(galleryViewModel.mListText.get(identifier), "500");
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });
        btn_NO3_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_nav_gallery_to_nav_no2fragment);
            }
        });

        return root;
    }

}
