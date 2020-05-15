package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TriggerResponse {
    @SerializedName("jsonrpc")
    @Expose
    private String jsonrpc;
    @SerializedName("result")
    @Expose
    private ArrayList<TriggerResult> result = null;
    @SerializedName("id")
    @Expose
    private Integer id;

    private Boolean isResult = false;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public ArrayList<TriggerResult> getResult() {
        return result;
    }

    public void setResult(ArrayList<TriggerResult> result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isResultSet() {
        if(this.result != null) this.isResult = true;
        return this.isResult;
    }
}
