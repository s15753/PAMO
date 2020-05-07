package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TriggerParams {
    @SerializedName("min_severity")
    @Expose
    private final Integer minSeverity = 2;
    @SerializedName("filter")
    @Expose
    private Filter filter;
    @SerializedName("skipDependent")
    @Expose
    private final String skipDependent = "true";
    @SerializedName("withLastEventUnacknowledged")
    @Expose
    private final String withLastEventUnacknowledged = "true";
    @SerializedName("selectLastEvent")
    @Expose
    private final String selectLastEvent = "extend";
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
