package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TriggerRequest {

    @SerializedName("jsonrpc")
    @Expose
    private final String jsonrpc = "2.0";
    @SerializedName("method")
    @Expose
    private final String method = "trigger.get";
    @SerializedName("id")
    @Expose
    private final Integer id = 2;
    @SerializedName("auth")
    @Expose
    private String token;
    @SerializedName("params")
    @Expose
    private TriggerParams params;

    public TriggerRequest(TriggerParams params, String token) {
        this.params = params;
        this.token = token;
    }
}
