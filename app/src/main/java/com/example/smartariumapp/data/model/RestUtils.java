package com.example.smartariumapp.data.model;


public class RestUtils {
    public static final String BASE_URL = "https://zolwik.tk";
//            Resources.getSystem().getString(R.string.base_url);

    public static ZabbixRestService getUserService(){
        return ZabbixApiClient.getRetrofitClient(BASE_URL).create(ZabbixRestService.class);
    }
}
