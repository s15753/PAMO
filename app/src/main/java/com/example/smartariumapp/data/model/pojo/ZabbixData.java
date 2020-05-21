package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Class used by Retrofit. Contain values needed to create ZabixSender request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class ZabbixData {
    /**
     * Host name
     */
    @SerializedName("host")
    @Expose
    private String host;

    /**
     * Item name
     */
    @SerializedName("item")
    @Expose
    private String item;

    /**
     * Item value
     */
    @SerializedName("value")
    @Expose
    private String value;

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
