package com.example.smartariumapp.data.model;

public class RestUtils {
    public static final String BASE_URL = "https://zolwik.tk";

    public static ZabbixRestService getUserService(){
        return ZabbixApiClient.getRetrofitClient(BASE_URL).create(ZabbixRestService.class);
    }
}
