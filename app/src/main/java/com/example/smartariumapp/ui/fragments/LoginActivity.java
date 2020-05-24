package com.example.smartariumapp.ui.fragments;
import com.example.smartariumapp.*;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.smartariumapp.R;
import com.example.smartariumapp.data.model.RestUtils;
import com.example.smartariumapp.data.model.ZabbixRestService;
import com.example.smartariumapp.data.model.pojo.LoginResponse;
import com.example.smartariumapp.data.model.pojo.User;
import com.example.smartariumapp.data.model.pojo.UserRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Login activity.
 * This activity is responsible for user authentication.
 *
 * @author Robert Chojdak
 * @version 2020.04
 * @since 1.0
 */

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    ZabbixRestService userService;
    ProgressBar loadingProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);

        /*
        Get ZabbixApiClient instance
         */
        userService = RestUtils.getUserService();

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(validateLogin(username, password)) {
                    UserRequest userRequest = getRestData(username, password);
                    doLogin(userRequest);
                }
            }
        });
    }

    /**
     * Method used for validation login values provided by user.
     *
     * @return Bundle object with passed userName and token.
     *
     */
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, getString(R.string.invalid_username), Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, getString(R.string.invalid_password), Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.trim().length() < 5){
            Toast.makeText(this, getString(R.string.invalid_password_short), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Method that creates object needed for JSON request.
     *
     * @param username login user name provided by user
     * @param password password provided by user
     *
     * @return UserRequest object with JSON authorization data.
     */
    private UserRequest getRestData(String username, String password) {
        User user = new User(username, password);
        UserRequest userRequest= new UserRequest(user);
        return userRequest;
    }

    // Send request to Zabbix, handle response and switch to MainActivity if token was returned
    /**
     * This method send login request to ZabbixApi, then handle response.
     * If response contain token method move user to MainActivity.
     * If request is valid but response doesn't contain token, Toast displays error message.
     * If request fail, Toast displays error message.
     *
     * @param userRequest object used to build JSON request for login purposes
     */
    private void doLogin(final UserRequest userRequest){
        // send request
        Call call = userService.loginRequest(userRequest);

        // get callback
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = (LoginResponse) response.body();
                    loadingProgressBar.setVisibility(View.GONE);
                    loginButton.setEnabled(true);

                    if(loginResponse.isResultSet()) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("token", loginResponse.getResult());
                        bundle.putString("userName", userRequest.getUsername());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, loginResponse.getErrorData(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                loadingProgressBar.setVisibility(View.GONE);
                loginButton.setEnabled(true);
            }
        });
    }
}