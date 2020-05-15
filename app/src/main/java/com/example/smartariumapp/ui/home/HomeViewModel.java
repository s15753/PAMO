package com.example.smartariumapp.ui.home;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.RestUtils;
import com.example.smartariumapp.data.model.ZabbixRestService;
import com.example.smartariumapp.data.model.pojo.Filter;
import com.example.smartariumapp.data.model.pojo.SendData;
import com.example.smartariumapp.data.model.pojo.TriggerParams;
import com.example.smartariumapp.data.model.pojo.TriggerRequest;
import com.example.smartariumapp.data.model.pojo.ZabbixData;

import java.util.ArrayList;

import retrofit2.Call;

public class HomeViewModel extends ViewModel {

    private ZabbixRestService requestSevice = RestUtils.getUserService();
    private ZabbixRestService sendRequestSevice = RestUtils.getSendService();;

    public HomeViewModel() {
    }

    public Call sendDataInstance() {
        SendData sendData = new SendData();
        sendData.setData(getRequests());
        Call call = sendRequestSevice.sendData(sendData);

        return call;
    }

    public Call getAlertInstance(String token) {
        Call call = requestSevice.triggerRequest(new TriggerRequest(
                        new TriggerParams(
                            new Filter()
                        ),
                        token
                ));

        return call;
    }

    public ArrayList<ZabbixData> getRequests() {
        ArrayList<ZabbixData> data = new ArrayList<>();
        for(ZabbixData zabbixData: DataHolder.getData().values()) {
            data.add(zabbixData);
        }

        return data;
    }

}