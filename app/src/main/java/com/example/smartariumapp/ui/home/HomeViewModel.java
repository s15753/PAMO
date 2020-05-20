package com.example.smartariumapp.ui.home;

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

    public HomeViewModel() {
    }

    public Call sendDataInstance(String user) {
        SendData sendData = new SendData();
        sendData.setData(getRequests());
        sendData.setUser(user);

        Call call = requestSevice.sendData(sendData);

        return call;
    }

    public Call getAlertInstance(String token) {
        Filter filter = new Filter();
        TriggerParams triggerParams = new TriggerParams(filter);
        TriggerRequest triggerRequest = new TriggerRequest(triggerParams, token);

        Call call = requestSevice.triggerRequest(triggerRequest);

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