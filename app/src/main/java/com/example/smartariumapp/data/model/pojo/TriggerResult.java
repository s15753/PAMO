package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Class used by Retrofit to handle Zabbix response for triggers. Catched response contain info
 * about triggerid, description, etc. Also contain info about host and last event.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class TriggerResult {

    /**
     * Trigger id
     */
    @SerializedName("triggerid")
    @Expose
    private String triggerid;

    /**
     * Trigger description
     */
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * Trigger last change unix format date
     */
    @SerializedName("lastchange")
    @Expose
    private String lastchange;

    /**
     * Host info for returned trigger.
     */
    @SerializedName("hosts")
    @Expose
    private List<Host> hosts = null;

    /**
     * Last event info for returned trigger.
     */
    @SerializedName("lastEvent")
    @Expose
    private LastTriggerEvent lastEvent;

    public TriggerResult(String triggerid, String description, String lastchange
                                                    , List<Host> hosts, LastTriggerEvent lastEvent) {
        this.triggerid = triggerid;
        this.description = description;
        this.lastchange = lastchange;
        this.hosts = hosts;
        this.lastEvent = lastEvent;
    }

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

