package com.example.smartariumapp.data.model.pojo;

import java.util.HashMap;

public class UserRequest {
    private String jsonrpc;
    private String method;
    private User params;
    private Integer id;

    public UserRequest (User params) {
        this.jsonrpc = "2.0";
        this.method = "user.login";
        this.params = params;
        this.id = 1;
    }
}
