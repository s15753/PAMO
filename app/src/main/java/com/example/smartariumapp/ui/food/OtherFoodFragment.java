package com.example.smartariumapp.ui.food;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

public class OtherFoodFragment extends Fragment {
    private Button[] buttons;
    private Button bt_back;
    private String[] my_Array;

    public OtherFoodFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_other_food, container, false);
        final TextView textView = root.findViewById(R.id.text_other_food);
        textView.setText("Other food");
        my_Array = getResources().getStringArray(R.array.food_other_strings);
        int n = my_Array.length;
        buttons = new Button[n];
        buttons[0] = root.findViewById(R.id.bt_other_food_0);
        buttons[1] = root.findViewById(R.id.bt_other_food_1);
        buttons[2] = root.findViewById(R.id.bt_other_food_2);
        buttons[3] = root.findViewById(R.id.bt_other_food_3);
        bt_back = root.findViewById(R.id.bt_back);

        for(int i = 0; i < n; i++){
            buttons[i].setText(my_Array[i]);
            final int identifier = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_set_parameters(my_Array, root, identifier);
                }
            });
        }
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_food);
            }
        });
        return root;
    }
    private void check_set_parameters(String[] my_Array, View root, int identifier){
        if(DataHolder.isKeyIn(my_Array[identifier])){
            DataHolder.removeByKey(my_Array[identifier]);
            Toast.makeText(getActivity(), "Usunięto "+my_Array[identifier]+" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{
            DataHolder.setMyData(my_Array[identifier], my_Array[identifier]);
            Toast.makeText(getActivity(), "Dodano "+ my_Array[identifier] + " do danych do wyałania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_home);

    }

}
