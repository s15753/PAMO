package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Class to build Zabbix trigger REST request using Retrofit2.
 *  Contain additional parameters keys for JSON request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class TriggerParams {
    /**
     * Minimum severity
     */
    @SerializedName("min_severity")
    @Expose
    private final Integer minSeverity = 2;

    /**
     * Additional filter values
     */
    @SerializedName("filter")
    @Expose
    private Filter filter;

    /**
     * Skip dependent info
     */
    @SerializedName("skipDependent")
    @Expose
    private final String skipDependent = "true";

    /**
     * With Last Event Unacknowledged info
     */
    @SerializedName("withLastEventUnacknowledged")
    @Expose
    private final String withLastEventUnacknowledged = "true";

    /**
     * Select Last Event info
     */
    @SerializedName("selectLastEvent")
    @Expose
    private final String selectLastEvent = "extend";

    /**
     * Select Host info
     */
    @SerializedName("selectHosts")
    @Expose
    private final String selectHosts = "extend";

    public TriggerParams(Filter filter) {
        this.filter = filter;
    }

    public Integer getMinSeverity() {
        return minSeverity;
    }

    public Filter getFilter() {
        return filter;
    }

    public String getSkipDependent() {
        return skipDependent;
    }

    public String getWithLastEventUnacknowledged() {
        return withLastEventUnacknowledged;
    }

    public String getSelectLastEvent() {
        return selectLastEvent;
    }

    public String getSelectHosts() {
        return selectHosts;
    }
}
