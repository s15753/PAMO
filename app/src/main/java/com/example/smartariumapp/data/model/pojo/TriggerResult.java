package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TriggerResult {
    @SerializedName("triggerid")
    @Expose
    private String triggerid;

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("lastchange")
    @Expose
    private String lastchange;
    @SerializedName("hosts")
    @Expose
    private List<Host> hosts = null;
    @SerializedName("lastEvent")
    @Expose
    private LastTriggerEvent lastEvent;

    public String getTriggerid() {
        return triggerid;
    }

    public String getDescription() {
        return description;
    }

    public String getLastchange() {
        return lastchange;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public LastTriggerEvent getLastEvent() {
        return lastEvent;
    }
}

