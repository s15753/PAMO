package com.example.smartariumapp;

import com.example.smartariumapp.data.model.RestUtils;
import com.example.smartariumapp.data.model.ZabbixApiClient;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ZabbixTest {

    @Test
    public void isApiClientCreated() {
        assertNotNull(RestUtils.getUserService());
    }

    @Test
    public void apiCreatesRetroftClient() {
        assertTrue(ZabbixApiClient.getRetrofitClient(RestUtils.BASE_URL) instanceof Retrofit);
    }

}
