package com.sample;

import java.util.List;

public class User4 {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<User4> getUsers() {
        return users;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    private String name;
    private String address;
    private String type;
    private List<User4> users;


    public User4(String name, List<User4> user4s, String type) {
        this.name = name;
        this.users = user4s;
        this.type = type;
    }

    public User4(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User4(String name, String address, String type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }
}
