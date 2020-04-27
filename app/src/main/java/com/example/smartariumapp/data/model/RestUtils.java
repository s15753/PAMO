package com.example.smartariumapp.data.model;

public class RestUtils {
    public static final String BASE_URL = "https://zolw.tk";

    public static ZabbixRestService getUserService(){
        return ZabbixApiClient.getRetrofitClient(BASE_URL).create(ZabbixRestService.class);
    }
}
