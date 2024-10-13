package com.demo_web_shop.model;

public class User {
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public int gender;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setGender(int gender) {
        this.gender = gender;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGender() {
        return gender;
    }

}
