package com.flipfit.bean;

public class Person {
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String id;
    private String role;

    public Person(String id, String userName, String email, String password, String role, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String role() {
        return role;
    }

    public Person setRole(String role) {
        this.role = role;
        return this;
    }

    public String userName() {
        return userName;
    }

    public Person setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String password() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public Person updatePassword(String password) {
        return setPassword(password);
    }

    public String email() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String firstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String id() {
        return id;
    }

    public Person setId(String id) {
        this.id = id;
        return this;
    }
}
