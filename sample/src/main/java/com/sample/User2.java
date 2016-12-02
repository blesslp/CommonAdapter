package com.sample;

import java.util.List;

/**
 * Created by liufan on 16/12/2.
 */

public class User2 {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String name;
    private List<User3> users;

    public List<User3> getUsers() {
        return users;
    }

    public User2(String name, List<User3> users) {
        this.name = name;
        this.users = users;
    }
}
