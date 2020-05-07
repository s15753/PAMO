package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastTriggerEvent {
    @SerializedName("eventid")
    @Expose
    private String eventid;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("objectid")
    @Expose
    private String objectid;
    @SerializedName("clock")
    @Expose
    private String clock;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("acknowledged")
    @Expose
    private String acknowledged;
    @SerializedName("ns")
    @Expose
    private String ns;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("severity")
    @Expose
    private String severity;

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(String acknowledged) {
        this.acknowledged = acknowledged;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
