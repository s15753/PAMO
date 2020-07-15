package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 *  Main class to build Zabbix trigger REST request using Retrofit2.
 *  Contain all key for JSON request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */
public class LogoutRequest {
    /**
     * jsonrpc version
     */
    @SerializedName("jsonrpc")
    @Expose
    private final String jsonrpc = "2.0";

    /**
     * Zabbix method used to logout
     */
    @SerializedName("method")
    @Expose
    private final String method = "user.logout";

    /**
     * Call id
     */
    @SerializedName("id")
    @Expose
    private final Integer id = 10;

    /**
     * Token value
     */
    @SerializedName("auth")
    @Expose
    private String token;

    /**
     * Additional parameters
     */
    @SerializedName("params")
    @Expose
    private ArrayList<String> params = new ArrayList<>();

    public LogoutRequest(String token) {
        this.token = token;
    }

}

