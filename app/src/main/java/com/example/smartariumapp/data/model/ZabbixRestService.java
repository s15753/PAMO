package com.example.smartariumapp.data.model;

import com.example.smartariumapp.data.model.pojo.LoginResponse;
import com.example.smartariumapp.data.model.pojo.LogoutResponse;
import com.example.smartariumapp.data.model.pojo.SendData;
import com.example.smartariumapp.data.model.pojo.SendDataResponse;
import com.example.smartariumapp.data.model.pojo.TriggerRequest;
import com.example.smartariumapp.data.model.pojo.TriggerResponse;
import com.example.smartariumapp.data.model.pojo.UserRequest;
import com.example.smartariumapp.data.model.pojo.LogoutRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *  Interfaces that define the possible HTTP operations via Retrofit client
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public interface ZabbixRestService {

    /**
     * Method for login purposes.
     *
     * @param userRequest JSON body with POST request
     * @return Response mapped into POJO classes.
     */
    @POST("/zabbix/api_jsonrpc.php")
    Call<LoginResponse> loginRequest(@Body UserRequest userRequest);

    /**
     * Method for logout purposes.
     *
     * @param logoutRequest JSON body with POST request
     * @return Response mapped into POJO classes.
     */
    @POST("/zabbix/api_jsonrpc.php")
    Call<LogoutResponse> logoutRequest(@Body LogoutRequest logoutRequest);

    /**
     * Method for login purposes.
     *
     * @param triggerRequest JSON body with POST request
     * @return Response mapped into POJO classes.
     */
    @POST("/zabbix/api_jsonrpc.php")
    Call<TriggerResponse> triggerRequest(@Body TriggerRequest triggerRequest);

    /**
     * Method for login purposes.
     *
     * @param sendData JSON body with POST request
     * @return Response mapped into POJO classes.
     */
    @POST("/app/scripts/android_request.php")
    Call<SendDataResponse> sendData(@Body SendData sendData);

}