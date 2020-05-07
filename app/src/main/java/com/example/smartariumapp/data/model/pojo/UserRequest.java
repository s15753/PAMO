package com.example.smartariumapp.data.model.pojo;

public class UserRequest {
    private final String jsonrpc = "2.0";
    private final String method = "user.login";
    private User params;
    private Integer id = 1;

    public UserRequest (User params) {
        this.params = params;
    }

    public String getUsername() {
        return this.params.getUser();
    }
}
