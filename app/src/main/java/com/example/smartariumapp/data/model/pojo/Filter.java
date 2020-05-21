package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Class used by Retrofit to filter request send to Zabbix.
 *
 * @author Robert Chojdak
 * @version 2020.04
 * @since 1.0
 */

public class Filter {
    /**
     * Filter value
     */
    @SerializedName("value")
    @Expose
    private final Integer value = 1;

    public Integer getValue() {
        return value;
    }
}
