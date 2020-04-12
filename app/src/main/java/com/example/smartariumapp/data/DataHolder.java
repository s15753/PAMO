package com.example.smartariumapp.data;

import java.util.HashMap;

public class DataHolder {
    private static HashMap<String, String> myData = new HashMap<>();
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
}
