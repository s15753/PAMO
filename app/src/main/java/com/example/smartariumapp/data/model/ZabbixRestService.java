package com.example.smartariumapp.data.model;

import com.example.smartariumapp.data.model.pojo.LoginResponse;
import com.example.smartariumapp.data.model.pojo.SendData;
import com.example.smartariumapp.data.model.pojo.SendDataResponse;
import com.example.smartariumapp.data.model.pojo.TriggerRequest;
import com.example.smartariumapp.data.model.pojo.TriggerResponse;
import com.example.smartariumapp.data.model.pojo.UserRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ZabbixRestService {

    @POST("/zabbix/api_jsonrpc.php")
    Call<LoginResponse> loginRequest(@Body UserRequest userRequest);

    @POST("/zabbix/api_jsonrpc.php")
    Call<TriggerResponse> triggerRequest(@Body TriggerRequest triggerRequest);

    @POST("/app/scripts/android_request.php")
    Call<SendDataResponse> sendData(@Body SendData sendData);

}