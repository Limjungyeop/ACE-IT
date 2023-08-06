package com.example.myapplication;

public class Users {

    String name;
    String age;
    String country;

    public Users(String name, String age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
