package com.example.smartariumapp.ui.other;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

/**
 * Fragment for water.
 *
 * This fragment is used to record water replacement or addition in monitored tank.
 *
 * If action is chosen twice instead of adding it to data to send we remove it from that list.
 *
 * @author Agnieszka Rydzyk
 * @version 2020.1505
 * @since 1.0
 */
public class WaterFragment extends Fragment {
    private int identifier = 2;
    private  Button bt_change, bt_refill, bt_send, bt_back;
    private String ammountString;
    private EditText amount;
    private int change_action = 1;

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
                if(amount.getVisibility() == View.GONE) {
                    bt_refill.setVisibility(View.INVISIBLE);
                    amount.setVisibility(View.VISIBLE);
                    bt_send.setVisibility(View.VISIBLE);
                    bt_send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ammountString = amount.getText().toString();
                            if(ammountString.equals(null) || ammountString.isEmpty()){
                                Toast.makeText(getActivity(), "Nie podano ilości wody!", Toast.LENGTH_SHORT).show();
                            }else{
                                check_set_parameters(change_action, root, title, ammountString);
                            }
                        }
                    });
                }else {
                    amount.setVisibility(View.GONE);
                    bt_send.setVisibility(View.GONE);
                    bt_refill.setVisibility(View.VISIBLE);
                }
            }
        });
        bt_refill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getVisibility() == View.GONE) {
                    bt_change.setVisibility(View.INVISIBLE);
                    amount.setVisibility(View.VISIBLE);
                    bt_send.setVisibility(View.VISIBLE);
                    bt_send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ammountString = amount.getText().toString();
                            if(ammountString.equals(null) || ammountString.isEmpty()){
                                Toast.makeText(getActivity(), "Nie podano ilości wymienionej wody!", Toast.LENGTH_SHORT).show();
                            }else{
                                check_set_parameters(change_action-1, root, title, ammountString);
                            }
                        }
                    });
                }else {
                    amount.setVisibility(View.GONE);
                    bt_send.setVisibility(View.GONE);
                    bt_change.setVisibility(View.VISIBLE);
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
    /**
     * Auxiliary method used to define actions caused by onclick action.
     *
     * @param title base for key in DataHolder
     * @param val how much water had been added or replaced
     * @param action action that is performed on parameter (0 - add, 1 - replace)
     * @param root current View
     */
    private void check_set_parameters(int action, View root, final String title, String val){
        if(DataHolder.isKeyIn(title)){
            DataHolder.removeByKey(title);
            Toast.makeText(getActivity(), "Usunięto " + title +" z danych do wysłania!", Toast.LENGTH_SHORT).show();

        }else{
            DataHolder.setMyData(title, new ZabbixData("Woda", action != 1 ? "add":"replace", val ));
            Toast.makeText(getActivity(), "Dodano "+ title + " "+ val+ "l do danych do wysłania!", Toast.LENGTH_SHORT).show();
        }
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Navigation.findNavController(root).navigate(R.id.nav_other);
    }
}
