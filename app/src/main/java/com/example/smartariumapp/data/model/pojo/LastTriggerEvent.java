package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class used by Retrofit to handle Zabbix response for triggers. Contain additional info for last
 * event
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class LastTriggerEvent {
    /**
     * Event id
     */
    @SerializedName("eventid")
    @Expose
    private String eventid;

    /**
     * Source info
     */
    @SerializedName("source")
    @Expose
    private String source;

    /**
     * Object info
     */
    @SerializedName("object")
    @Expose
    private String object;

    /**
     * Object id
     */
    @SerializedName("objectid")
    @Expose
    private String objectid;

    /**
     * Clock info
     */
    @SerializedName("clock")
    @Expose
    private String clock;

    /**
     * Value info
     */
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * Acknowledged info
     */
    @SerializedName("acknowledged")
    @Expose
    private String acknowledged;

    /**
     * Ns info
     */
    @SerializedName("ns")
    @Expose
    private String ns;

    /**
     * Ns info
     */
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * Severity info
     */
    @SerializedName("severity")
    @Expose
    private String severity;

    public LastTriggerEvent(String eventid, String objectid, String value, String name, String severity) {
        this.eventid = eventid;
        this.objectid = objectid;
        this.value = value;
        this.name = name;
        this.severity = severity;
    }

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
