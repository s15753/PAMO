package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SendData {
    @SerializedName("data")
    @Expose
    private ArrayList<ZabbixData> data = null;

    @SerializedName("user")
    @Expose
    private String user;

    public ArrayList<ZabbixData> getData() {
        return data;
    }

    public void setData(ArrayList<ZabbixData> data) {
        this.data = data;
    }

    public void setUser(String user) { this.user = user; }

    @Override
    public String toString() {
        String string = this.user + " ";
        for(ZabbixData value: data) {
            string += value.getHost() + " " + value.getItem() + " " + value.getValue() + "   ";
        }
        return string;
    }
}
