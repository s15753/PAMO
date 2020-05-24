package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 *  Class used by Retrofit to get response from Zabbix. Handle JSON response for triggers.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class TriggerResponse {
    /**
     * jsonrpc version
     */
    @SerializedName("jsonrpc")
    @Expose
    private String jsonrpc;

    /**
     * Trigger results returned from Zabbix
     */
    @SerializedName("result")
    @Expose
    private ArrayList<TriggerResult> result = null;

    /**
     * Call id
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    private Boolean isResult = false;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public ArrayList<TriggerResult> getResult() {
        return result;
    }

    public void setResult(ArrayList<TriggerResult> result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Method checks if returned json contain result key
     * @return TRUE if key result "was" find in response
     */
    public Boolean isResultSet() {
        if(this.result != null) this.isResult = true;
        return this.isResult;
    }

    /**
     * Method checks if returned json contain result key
     * @return numbers of alerts
     */
    public Integer countResults() {
        return this.result.size();
    }
}
