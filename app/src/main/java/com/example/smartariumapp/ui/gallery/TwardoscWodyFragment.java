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

public class TwardoscWodyFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private int identifier = 2;
    private String ans;
    private Button btn_NO3_0, btn_NO3_10, btn_NO3_25, btn_NO3_50;

    public static TwardoscWodyFragment newInstance() {
        return new TwardoscWodyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.twardosc_wody_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_twardosc);
        galleryViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return root;
    }


}
