package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendDataResponse {
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;

    @SerializedName("response")
    @Expose
    private Integer response;

    public String getResponseMsg() {
        return responseMsg;
    }

    public Integer getResponse() {
        return response;
    }
}
