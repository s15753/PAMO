package com.example.smartariumapp.ui.home;

import androidx.lifecycle.ViewModel;
import com.example.smartariumapp.data.DataHolder;
import com.example.smartariumapp.data.model.RestUtils;
import com.example.smartariumapp.data.model.ZabbixRestService;
import com.example.smartariumapp.data.model.pojo.Filter;
import com.example.smartariumapp.data.model.pojo.LogoutRequest;
import com.example.smartariumapp.data.model.pojo.SendData;
import com.example.smartariumapp.data.model.pojo.TriggerParams;
import com.example.smartariumapp.data.model.pojo.TriggerRequest;
import com.example.smartariumapp.data.model.pojo.ZabbixData;
import java.util.ArrayList;
import retrofit2.Call;

/**
 * Hold and manage UI-related data in a life-cycle conscious way.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class HomeViewModel extends ViewModel {
    /**
     * ZabbixRestService instance
     */
    private ZabbixRestService requestSevice = RestUtils.getUserService();

    public HomeViewModel() {
    }

    /**
     * Method create REST call with user data, which will be send to Zabbix
     *
     * @param user userName provided in login activity
     *
     * @return call ready to send call
     */
    public Call sendDataInstance(String user, String token) {
        SendData sendData = new SendData();
        sendData.setData(getRequests());
        sendData.setUser(user);
        sendData.setToken(token);

        Call call = requestSevice.sendData(sendData);

        return call;
    }

    /**
     * Method create REST call, which will be send to Zabbix to retrive
     *
     * @param token userName provided in login activity
     *
     * @return call ready to send call
     */
    public Call getAlertInstance(String token) {
        Filter filter = new Filter();
        TriggerParams triggerParams = new TriggerParams(filter);
        TriggerRequest triggerRequest = new TriggerRequest(triggerParams, token);

        Call call = requestSevice.triggerRequest(triggerRequest);

        return call;
    }

    /**
     * Method create REST call with user data, which will be send to Zabbix
     *
     * @param user userName provided in login activity
     *
     * @return call ready to send call
     */
    public Call logoutInstance(String token) {
        LogoutRequest logoutRequest = new LogoutRequest(token);

        Call call = requestSevice.logoutRequest(logoutRequest);

        return call;
    }

    /**
     * Method retrieves data provided by user and put it into request object
     *
     * @return data object with user data
     */
    public ArrayList<ZabbixData> getRequests() {
        ArrayList<ZabbixData> data = new ArrayList<>();
        for(ZabbixData zabbixData: DataHolder.getData().values()) {
            data.add(zabbixData);
        }

        return data;
    }
}