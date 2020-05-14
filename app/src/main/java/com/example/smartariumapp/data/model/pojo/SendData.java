package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SendData {
    @SerializedName("data")
    @Expose
    private ArrayList<ZabbixData> data = null;

//    @SerializedName("user")
//    @Expose
//    private String user = "robert";

    public ArrayList<ZabbixData> getData() {
        return data;
    }

    public void setData(ArrayList<ZabbixData> data) {
        this.data = data;
    }
}
