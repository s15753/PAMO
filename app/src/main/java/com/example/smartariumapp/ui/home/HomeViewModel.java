package com.example.smartariumapp.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.smartariumapp.MainActivity;
import com.example.smartariumapp.data.model.RestUtils;
import com.example.smartariumapp.data.model.ZabbixRestService;
import com.example.smartariumapp.data.model.pojo.Filter;
import com.example.smartariumapp.data.model.pojo.TriggerParams;
import com.example.smartariumapp.data.model.pojo.TriggerRequest;

import retrofit2.Call;

public class HomeViewModel extends ViewModel {

    private ZabbixRestService requestSevice;

    public HomeViewModel() {
    }

    public Call getRequestInstance(String token) {
        requestSevice = RestUtils.getUserService();
        Call call = requestSevice.triggerRequest(new TriggerRequest(
                        new TriggerParams(
                                new Filter()
                        ),
                        token
                ));

        return call;
    }

}