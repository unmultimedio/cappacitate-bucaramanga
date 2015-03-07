package com.cappacitate2015.fragmentos2;

/**
 * Created by julianfigueroa on 3/7/15.
 */
public class User {

    private String name;
    private String position;

    public User(String position, String name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
