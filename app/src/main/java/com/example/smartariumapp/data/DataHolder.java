package com.example.smartariumapp.data;

import com.example.smartariumapp.data.model.pojo.ZabbixData;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {
    private static Map<String, ZabbixData> myData = new HashMap<>();

    public static Map<String, ZabbixData> getData() {return myData;}

    public static ZabbixData getDataByKey(String key){return myData.get(key);}

    public static void setMyData(String key, ZabbixData value){
        System.out.println("Key: " + key + ", my zabbix data host: " + value.getHost() + " item: " + value.getItem() + " value: "+value.getValue() );
        DataHolder.myData.put(key, value);
    }

    public static boolean isKeyIn(String key){
        return myData.containsKey(key);
    }

    public static void removeAll(){
        myData.clear();
    }

    public static int checkLength(){
        return myData.size();
    }

    public static void removeByKey(String key){
        myData.remove(key);
    }

    public static String myDataToString(){
        StringBuilder my_string = new StringBuilder();
        for(Map.Entry<String, ZabbixData> entry: myData.entrySet()){
            my_string.append(entry.getKey() + ": "+entry.getValue().getValue()+"\n");
            System.out.println(my_string);
        }
        return my_string.toString();
    }
}
