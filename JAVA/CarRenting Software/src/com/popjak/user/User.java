package com.popjak.user;

import java.util.Objects;

public class User {

    private final String userid;
    private final String name;

    public User(String userid, String name) {
        this.userid = userid;
        this.name = name;
    }


    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return userid + "," + name + "\n";
    }
    public String userString() {
        return name + "," + userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name);
    }
}
