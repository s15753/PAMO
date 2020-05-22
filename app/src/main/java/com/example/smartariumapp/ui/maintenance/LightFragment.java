package com.example.smartariumapp.ui.maintenance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;

/**
 * Fragment for light settings.
 *
 * This fragment is used to set light intervals in tank.
 * System allows user to set two intervals - when light is turn on and off all the time.
 * Between this intervals are areas when light will be turn on if animal is under the light bulb.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class LightFragment extends Fragment {
    private int identifier = 0;
    private Button bt_back, bt_send;
    private String[] myStrings, lightAnsValues;
    private EditText[] myEditText;
    public LightFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_light, container, false);
        final TextView textView = root.findViewById(R.id.text_light);
        final String title = getResources().getStringArray(R.array.maintenance_main_strings)[identifier];
        textView.setText(title);
        lightAnsValues = getResources().getStringArray(R.array.light_ans_values);
        bt_back = root.findViewById(R.id.bt_back);
        bt_send = root.findViewById(R.id.bt_send);
        myEditText = new EditText[4];
        myEditText[0] = root.findViewById(R.id.light_on_from);
        myEditText[1] = root.findViewById(R.id.light_on_to);
        myEditText[2] = root.findViewById(R.id.light_conditional_from);
        myEditText[3] = root.findViewById(R.id.light_conditional_to);
        myStrings = new String[4];



        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_status = true;
                for(int k = 0; k < myEditText.length; k++){
                    if(hourFilter(myEditText[k].getText().toString())) {
                        myStrings[k] = myEditText[k].getText().toString();
                    }else{
                        myStrings[k] = "";
                    }
                }
                for(int k = 0; k < myEditText.length; k += 2){
                    if(!myStrings[k].isEmpty() && !myStrings[k+1].isEmpty()){
                        check_status = false;
                        check_set_parameters(lightAnsValues[k], myStrings[k], root);
                        check_set_parameters(lightAnsValues[k + 1], myStrings[k + 1], root);
                    }
                }
                if(check_status){
                    Toast.makeText(getActivity(), "Brak wystaraczającej ilości danych", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
            }
        });
        return root;
    }
    /**
     * Auxiliary method used to define actions caused by onclick action.
     *
     *
     * @param parameter parameter that we want to set
     * @param ans value of hour
     * @param root current View
     */
    private void check_set_parameters(String parameter, String ans, View root){
        if(DataHolder.isKeyIn(parameter)){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            //DataHolder.setMyData(parameter, ans);
            Toast.makeText(getActivity(), parameter+ " "+ans, Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
        }
    }
    /**
     * Auxiliary method used to examine correctness of hour
     *
     * @param source value of hour set by user
     */
    private boolean hourFilter(String source){
        if(source.length() > 5 || source.length() < 4){
            return false;
        }
        else {
            String substringHours = source.subSequence(0, source.length()-3).toString();
            String substringMinutes = source.subSequence(source.length()-2, source.length()).toString();
            try{
                int hours = Integer.parseInt(substringHours);
                int minutes = Integer.parseInt(substringMinutes);
                if(minutes >= 0 && minutes < 60 && hours >= 0 && hours < 24){
                    return true;
                }else{
                    return false;
                }
            }catch(NumberFormatException err){
                return false;
            }
        }
    }
}