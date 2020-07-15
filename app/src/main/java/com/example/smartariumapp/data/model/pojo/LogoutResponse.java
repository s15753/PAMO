package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    /**
     * jsonrpc version
     */
    @SerializedName("jsonrpc")
    private String jsonrpc;

    /**
     * Call id
     */
    @SerializedName("id")
    private String id;

    /**
     * True if correctly logout
     */
    @SerializedName("result")
    private Boolean result;

    /**
     * Returned code, message and data
     */
    @SerializedName("error")
    private Error error;

    /**
     * Set to true if result key was returned
     */
    private Boolean isResult = false;

    public Boolean getResult() {
        return result;
    }

    public Error getError() {
        return error;
    }

    /**
     * Method gets error message
     * @return returned error mesage
     */
    public String getErrorMessage() { return error.getMessage(); }

    /**
     * Method gets error data
     * @return returned error data
     */
    public String getErrorData() { return error.getData(); }

    /**
     * Method checks if returned json contain result key
     * @return TRUE if key "result" was find in response
     */
    public Boolean isResultSet() {
        if(this.result) this.isResult = true;
        return this.isResult;
    }

}
