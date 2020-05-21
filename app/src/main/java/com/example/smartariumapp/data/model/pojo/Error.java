package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *  Class used by Retrofit. Keeps errors returned by JSON REST call
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class Error {

    /**
     * Returned error code
     */
    @SerializedName("code")
    private String code;

    /**
     * Returned error message
     */
    @SerializedName("message")
    private String message;

    /**
     * Returned error data
     */
    @SerializedName("data")
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return "error code: " + code + "error message: " + message + "error data: " + data;
    }
}
