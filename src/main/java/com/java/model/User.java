package com.java.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String username;
    private Integer age;
    private String city;

    public User() {
    }

    public User(String username, Integer age, String city) {
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
