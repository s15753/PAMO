package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("jsonrpc")
    private String jsonrpc;

    @SerializedName("result")
    private String result;

    @SerializedName("id")
    private String id;

    @SerializedName("error")
    private Error error;

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

    public String getErrorMessage() { return error.getMessage(); }

    public String getErrorData() { return error.getData(); }

    public Boolean isResultSet() {
        if(this.result != null) this.isResult = true;
        return this.isResult;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", result='" + result + '\'' +
                ", id='" + id + '\'' +
                ", error=" + error +
                '}';
    }
}
