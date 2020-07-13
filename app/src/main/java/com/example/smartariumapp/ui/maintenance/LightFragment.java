package com.example.smartariumapp.ui.maintenance;

import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
    private String[] myStrings, lightKeysValues, lightReadable;
    private EditText[] myEditText;
    TimePickerDialog picker;

    public LightFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        final View root = inflater.inflate(R.layout.fragment_light, container, false);
        final TextView textView = root.findViewById(R.id.text_light);
        final String title = getResources().getStringArray(R.array.maintenance_main_strings)[identifier];
        textView.setText(title);
        lightKeysValues = getResources().getStringArray(R.array.light_keys_values);
        lightReadable = getResources().getStringArray(R.array.light_ans_values);
        bt_back = root.findViewById(R.id.bt_back);
        bt_send = root.findViewById(R.id.bt_send);
        myEditText = new EditText[4];
        myEditText[0] = root.findViewById(R.id.light_on_since);
        myEditText[1] = root.findViewById(R.id.light_on_to);
        myEditText[2] = root.findViewById(R.id.light_off_since);
        myEditText[3] = root.findViewById(R.id.light_off_to);
        for (final EditText item: myEditText){
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Calendar cldr = Calendar.getInstance();
                    int hour = cldr.get(Calendar.HOUR_OF_DAY);
                    int minutes = cldr.get(Calendar.MINUTE);
                    // time picker dialog
                    picker = new TimePickerDialog(root.getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                    item.setText(String.format("%02d:%02d", sHour, sMinute));
                                }
                            }, hour, minutes, true);
                    picker.show();                }
            });
        }
        myStrings = new String[4];

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_status = false;
                for(int k = 0; k < myEditText.length; k++){
                    if(hourFilter(myEditText[k].getText().toString())) {
                        myStrings[k] = myEditText[k].getText().toString();
                    }else{
                        myStrings[k] = "";
                        check_status = true;
                    }
                }
                if(!check_status){
                    try {
                        Date start = dateFormat.parse(myStrings[0]);
                        Date stop = dateFormat.parse(myStrings[1]);
                        Date start_1 = dateFormat.parse(myStrings[2]);
                        Date stop_1 = dateFormat.parse(myStrings[3]);
                        if(start.before(stop) && start_1.before(stop_1)){
                            if((start.before(start_1) && (stop.before(start_1) || stop.equals(start_1))) || ((start.after(stop_1) || start.equals(stop_1)) && stop.after(stop_1))) {
                                for(int k = 0; k < myEditText.length; k += 2){
                                    check_set_parameters(k, myStrings[k], root);
                                    check_set_parameters(k+1, myStrings[k + 1], root);
                                }
                                Toast.makeText(getActivity(), "Pomyślnie dodano dane!", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
                                finalize();
                            }else{
                                check_status = true;
                            }
                        }else if(start.after(stop) && start_1.before(stop_1)){
                            if((stop_1.after(start_1) && (start_1.after(stop) || start_1.equals(stop))) && (start_1.before(stop_1) && (stop_1.before(start) || stop_1.equals(start)))){
                                for(int k = 0; k < myEditText.length; k += 2){
                                    check_set_parameters(k, myStrings[k], root);
                                    check_set_parameters(k+1, myStrings[k + 1], root);
                                }
                                Toast.makeText(getActivity(), "Pomyślnie dodano dane!", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
                                finalize();
                            }else{
                                check_status = true;
                            }
                        }else if(start_1.after(stop_1) && start.before(stop)){
                            if((stop.after(start) && (start.after(stop_1) || start.equals(stop_1))) && (start.before(stop) && (stop.before(start_1) || stop.equals(start_1)))){
                                for(int k = 0; k < myEditText.length; k += 2){
                                    check_set_parameters(k, myStrings[k], root);
                                    check_set_parameters(k+1, myStrings[k + 1], root);
                                }
                                Toast.makeText(getActivity(), "Pomyślnie dodano dane!", Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
                                finalize();
                            }else{
                                check_status = true;
                            }
                        }else{
                            check_status = true;
                        }
                    } catch (ParseException e) {
                        Toast.makeText(getActivity(), "Coś poszło nie tak!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
                if(check_status){
                    Toast.makeText(getActivity(), "Niepoprawny format!", Toast.LENGTH_SHORT).show();
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
     * @param key index of readable and key string value
     * @param ans hour value
     * @param root current View
     */
    private void check_set_parameters(int key, String ans, View root){
        if(DataHolder.isKeyIn(this.lightReadable[key])){
            Toast.makeText(getActivity(), "Najpierw należy wysłać już zgromadzone dane!", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            if(ans.length() < 5){
                DataHolder.setMyData(this.lightReadable[key], new ZabbixData("Oswietlenie", this.lightKeysValues[key], "0"+ans));
                Toast.makeText(getActivity(), this.lightReadable[key]+ " "+ans, Toast.LENGTH_SHORT).show();
                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
            }else{
                DataHolder.setMyData(this.lightReadable[key], new ZabbixData("Oswietlenie", this.lightKeysValues[key], ans));
                Toast.makeText(getActivity(), this.lightReadable[key]+ " "+ans, Toast.LENGTH_SHORT).show();
                Navigation.findNavController(root).navigate(R.id.nav_main_maintenance);
            }
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

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
