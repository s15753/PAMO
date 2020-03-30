package com.example.smartariumapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;


public class ClFragment extends Fragment {
    private GalleryViewModel galleryViewModel;
    private int identifier = 5;
    private Button[] buttons;
    private Button btn_Cl_none;
    String[] my_Array;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_cl, container, false);
        final TextView textView = root.findViewById(R.id.text_Cl);

        my_Array = getResources().getStringArray(R.array.water_param_values_Cl);
        galleryViewModel.getText(identifier).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        buttons = new Button[4];
        buttons[0] = root.findViewById(R.id.bt_Cl_0);
        buttons[1] = root.findViewById(R.id.bt_Cl_0_8);
        buttons[2] = root.findViewById(R.id.bt_Cl_1_5);
        buttons[3] = root.findViewById(R.id.bt_Cl_3);
        btn_Cl_none = root.findViewById(R.id.bt_lack_of_data);
        int n = buttons.length;
        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i] + " mg/l");
            final String my_text = my_Array[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(my_text, root, galleryViewModel, identifier);
                }
            });
        }
        btn_Cl_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_home);
            }
        });

        return root;
    }

    private void check_set_parameters(String ans, View root, GalleryViewModel galleryViewModel, int identifier){
        if(DataHolder.isKeyIn(galleryViewModel.mListText.get(identifier))){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_home);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            DataHolder.setMyData(galleryViewModel.mListText.get(identifier), ans);
            Toast.makeText(getActivity(), galleryViewModel.mListText.get(identifier)+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_home);
        }

    }
}
