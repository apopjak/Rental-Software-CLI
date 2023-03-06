package com.popjak.user;

import java.util.UUID;

public class User {

    private UUID userid;
    private String name;

    public User(String name) {
        userid = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return userid + "," + name + "\n";
    }

    public UUID getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }
}
