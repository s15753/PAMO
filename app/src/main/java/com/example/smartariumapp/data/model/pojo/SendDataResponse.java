package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Class used by Retrofit to get response from server. Handle JSON response for sent user data.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class SendDataResponse {
    /**
     * Response message
     */
    @SerializedName("responseMsg")
    @Expose
    private String responseMsg;

    /**
     * Response code: 0 - failed, 1 - success
     */
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
