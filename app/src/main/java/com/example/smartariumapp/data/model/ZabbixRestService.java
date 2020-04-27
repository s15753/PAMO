package com.example.smartariumapp.data.model;

import com.example.smartariumapp.data.model.pojo.LoginResponse;
import com.example.smartariumapp.data.model.pojo.UserRequest;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ZabbixRestService {

    @POST("/zabbix/api_jsonrpc.php")
    Call<LoginResponse> loginRequest(@Body UserRequest userRequest);

}