package com.example.smartariumapp.data.model.pojo;

/**
 *  Class used by Retrofit. Contain authentication parameters.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class User {
    /**
     * User name for authentication
     */
    private String user;

    /**
     * Password for authentication
     */
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
