package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Main class to build JSON REST request using Retrofit2.
 *  Contain all needed keys for JSON request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

import java.util.ArrayList;

public class SendData {
    /**
     * Data send to server
     */
    @SerializedName("data")
    @Expose
    private ArrayList<ZabbixData> data = null;

    /**
     * Username
     */
    @SerializedName("user")
    @Expose
    private String user;

    /**
     * Token
     */
    @SerializedName("token")
    @Expose
    private String token;

    public ArrayList<ZabbixData> getData() {
        return data;
    }

    public void setData(ArrayList<ZabbixData> data) {
        this.data = data;
    }

    public void setUser(String user) { this.user = user; }

    public void setToken(String token) { this.token = token; }

    @Override
    public String toString() {
        String string = this.user + " ";
        for(ZabbixData value: data) {
            string += value.getHost() + " " + value.getItem() + " " + value.getValue() + "   ";
        }
        return string;
    }
}
