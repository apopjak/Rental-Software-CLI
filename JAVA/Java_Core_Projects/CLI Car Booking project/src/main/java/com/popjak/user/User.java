package com.popjak.user;

import com.github.javafaker.Faker;

public class User {

    private final String userid;
    private final String name;

    private String address;
    private String phone;
    private String email;


    public User(String userid, String name) {
        Faker faker = new Faker();
        this.userid = userid;
        this.name = name;
        this.address = faker.address().fullAddress();
        this.phone = faker.phoneNumber().cellPhone();
        this.email = faker.internet().emailAddress();
    }


    public String fullString() {
        return "name: " + name +
                ", userid: " + userid +
                ", address: " + address  +
                ", phone: " + phone +
                ", email: " + email;
    }
    @Override
    public String toString() {
        return userid + "," + name + "\n";
    }

    public String userString() {
        return name + "," + userid;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
