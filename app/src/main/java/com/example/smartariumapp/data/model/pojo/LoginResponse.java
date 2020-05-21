package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *  Class used by Retrofit to get response from Zabbix. Handle JSON response for login activity.
 *  Two kind of responses can be handled, success and fail. Keys returned for success:
 *  - jsonrpc
 *  - result
 *  - id
 *  Keys returned by fail:
 *  - jsonrpc
 *  - error
 *  - id
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class LoginResponse {

    /**
     * jsonrpc version
     */
    @SerializedName("jsonrpc")
    private String jsonrpc;

    /**
     * Returned token
     */
    @SerializedName("result")
    private String result;

    /**
     * Call id
     */
    @SerializedName("id")
    private String id;

    /**
     * Returned code, message and data
     */
    @SerializedName("error")
    private Error error;

    /**
     * Set to true if result key was returned
     */
    private Boolean isResult = false;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
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
        if(this.result != null) this.isResult = true;
        return this.isResult;
    }

    @Override
    public String toString() {
        return  "jsonrpc= " + jsonrpc +
                ", result= " + result +
                ", id= " + id +
                ", error= " + error.toString();
    }
}
