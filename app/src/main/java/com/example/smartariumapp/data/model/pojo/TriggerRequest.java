package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Main class to build Zabbix trigger REST request using Retrofit2.
 *  Contain all key for JSON request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class TriggerRequest {
    /**
     * jsonrpc version
     */
    @SerializedName("jsonrpc")
    @Expose
    private final String jsonrpc = "2.0";

    /**
     * Zabbix method used to get triggers
     */
    @SerializedName("method")
    @Expose
    private final String method = "trigger.get";

    /**
     * Call id
     */
    @SerializedName("id")
    @Expose
    private final Integer id = 2;

    /**
     * Toke value
     */
    @SerializedName("auth")
    @Expose
    private String token;

    /**
     * Additional parameters
     */
    @SerializedName("params")
    @Expose
    private TriggerParams params;

    public TriggerRequest(TriggerParams params, String token) {
        this.params = params;
        this.token = token;
    }
}
