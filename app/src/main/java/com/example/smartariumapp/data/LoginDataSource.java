package com.example.smartariumapp.data;

import android.util.Log;

import com.example.smartariumapp.data.model.LoggedInUser;
import com.example.smartariumapp.data.model.ZabbixApiClient;
import com.example.smartariumapp.data.model.ZabbixRestService;
import com.example.smartariumapp.data.model.pojo.LoginResponse;
import com.example.smartariumapp.data.model.pojo.User;
import com.example.smartariumapp.data.model.pojo.UserRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    String token;
    String error;

    public Result<LoggedInUser> login(String username, String password) {

        try {
            User user = new User(username, password);
            UserRequest userRequest = new UserRequest(user);

            Retrofit retrofit = ZabbixApiClient.getRetrofitClient();
            ZabbixRestService zabbixAPIs = retrofit.create(ZabbixRestService.class);

            Call call = zabbixAPIs.loginRequest(userRequest);

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.isSuccessful()) {
                        LoginResponse loginResponse = (LoginResponse) response.body();

                        if (response.body().toString().contains("result")) token = loginResponse.getResult();
                        if (response.body().toString().contains("error")) error = loginResponse.getErrorData();
                    }
                }
                @Override
                public void onFailure(Call call, Throwable t) {
                    if (t instanceof IOException) {Log.e("Error", " network issue");}
                    else {Log.d("Error", "other issue");}
                }
            });
            Log.v("TOKEN", token);
//            if (instanceof Result.Success)
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
