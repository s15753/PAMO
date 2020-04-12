package com.example.smartariumapp.data;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {
    private static Map<String, String> myData = new HashMap<>();
    public static String getDataByKey(String key){return myData.get(key);}
    public static void setMyData(String key, String value){
        System.out.println("my val: "+value+" and key: "+key);
        DataHolder.myData.put(key,value);
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
        for(Map.Entry<String,String> entry: myData.entrySet()){
            my_string.append(entry.getKey() + ": "+entry.getValue()+"\n");
            System.out.println(my_string);
        }
        return my_string.toString();
    }
}
