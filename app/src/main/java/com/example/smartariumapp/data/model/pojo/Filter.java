package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filter {
    @SerializedName("value")
    @Expose
    private final Integer value = 1;

    public Integer getValue() {
        return value;
    }
}
