package com.example.smartariumapp.data;

import com.example.smartariumapp.data.model.pojo.ZabbixData;

import java.util.HashMap;
import java.util.Map;

/**
 * Static class used to store gathered data.
 *
 *
 * @author Agnieszka Rydzyk
 * @version 2020.05
 * @since 1.0
 */
public class DataHolder {
    /**
     * Map where data prepared for Zabbix are stored using suitable and human readable key
     */
    private static Map<String, ZabbixData> myData = new HashMap<>();

    /**
     * Method returns myData map
     *
     * @return myData map
     */
    public static Map<String, ZabbixData> getData() {return myData;}

    /**
     * Method adding new key and value pair to myData map
     *
     * @param key human readable key
     * @param value data prepared to send to Zabbix
     */
    public static void setMyData(String key, ZabbixData value){
        DataHolder.myData.put(key, value);
    }

    /**
     * Method checking if myData map contains special key
     *
     * @param key human readable key
     * @return True if key in map and false otherwise.
     */
    public static boolean isKeyIn(String key){
        return myData.containsKey(key);
    }

    /**
     * Method removing all key-value pairs from myData
     *
     */
    public static void removeAll(){
        myData.clear();
    }

    /**
     * Method returning myData size
     *
     * @return Size of myData map
     */
    public static int checkLength(){
        return myData.size();
    }

    /**
     * Method removing key-value pair from myData using key
     *
     * @param key human readable key
     */
    public static void removeByKey(String key){
        myData.remove(key);
    }

    /**
     * Method returning all data gathered as a string in special order and human readable format
     * If
     *
     * @return Gathered data as a string
     */
    public static String myDataToString(){
        StringBuilder my_string = new StringBuilder();
        String[] waterKeys = {"NO3", "NO2", "GH1", "KH", "pH", "Cl", "Woda"};
        for(String item: waterKeys){
            if(myData.containsKey(item)){
                my_string.append(item + ": " + myData.get(item).getValue() + "\n");
            }
        }
        for(Map.Entry<String, ZabbixData> entry: myData.entrySet()){
            if(entry.getValue().getHost().equalsIgnoreCase("Jedzenie")){
                my_string.append(entry.getKey() + "\n");
            }
        }
        for(Map.Entry<String, ZabbixData> entry: myData.entrySet()) {
            if (entry.getValue().getHost().equalsIgnoreCase("Zolwie")) {
                my_string.append(entry.getKey() + ": " + entry.getValue().getValue() + "\n");
            }
        }
        String[] otherKeys = {"Zawsze wyłączone do", "Zawsze włączone od", "Zawsze włączone do", "Zawsze wyłączone od"};
        for(String item: otherKeys){
            if(myData.containsKey(item)){
                my_string.append(item + ": " + myData.get(item).getValue() + "\n");
            }
        }
        String[] otherKeys2 = {"Żarówka", "Gąbka", "Wata", "Żwir", "Ceramika"};
        for(String item: otherKeys2){
            if(myData.containsKey(item)){
                my_string.append(item + ": " + (myData.get(item).getItem().equalsIgnoreCase("replace") ? "wymiana" : "czyszczenie") + "\n");
            }
        }
        return my_string.toString();
    }
}
