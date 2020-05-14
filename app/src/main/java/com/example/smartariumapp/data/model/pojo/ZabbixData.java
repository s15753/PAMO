package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZabbixData {
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("value")
    @Expose
    private String value;
    private String date;

    public ZabbixData(String host, String item, String value) {
        this.host = host;
        this.item = item;
        this.value = value;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
