package com.example.smartariumapp.data.model.pojo;

/**
 *  Main class to build Zabbix login REST request using Retrofit2.
 *  Contain all key for JSON request.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class UserRequest {
    /**
     * jsonrpc version
     */
    private final String jsonrpc = "2.0";

    /**
     * Zabbix method used for authentication
     */
    private final String method = "user.login";

    /**
     * Additional parameters needed for authentication.
     */
    private User params;

    /**
     * Call id
     */
    private Integer id = 1;

    public UserRequest (User params) {
        this.params = params;
    }

    public String getUsername() {
        return this.params.getUser();
    }
}
