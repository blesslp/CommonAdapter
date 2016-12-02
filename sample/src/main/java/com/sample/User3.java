package com.sample;

/**
 * Created by liufan on 16/12/2.
 */

public class User3 {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name;
    private String address;

    public User3(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
