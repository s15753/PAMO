package com.example.smartariumapp.data.model;

import com.example.smartariumapp.R;

public class RestUtils {
    public static final String BASE_URL = "https://zolwik.tk";
    public static final String BASE_SEND_URL = "http://10.0.2.2";

    public static ZabbixRestService getUserService(){
        return ZabbixApiClient.getRetrofitClient(BASE_URL).create(ZabbixRestService.class);
    }

    public static ZabbixRestService getSendService(){
        return ZabbixApiClient.getRetrofitClient(BASE_SEND_URL).create(ZabbixRestService.class);
    }
}
