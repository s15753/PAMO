package com.example.smartariumapp.data.model;

/**
 *  Class take Retrofit client and return calls from ZabbixApiService.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class RestUtils {

    /**
     * Base URL for retrofit client.
     */
    public static String BASE_URL = "https://zolwik.tk";

    /**
     * This public static method will return calls for all method in ZabbixApiService.
     *
     * @return Retrofit calls.
     *
     */
    public static ZabbixRestService getUserService(){
        return ZabbixApiClient.getRetrofitClient(BASE_URL).create(ZabbixRestService.class);
    }
}
