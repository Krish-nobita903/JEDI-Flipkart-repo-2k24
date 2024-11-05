package com.flipfit.bean;

public class Admin extends Person{
    public Admin(String id, String name, String email, String password, String firstName, String lastName) {
        super(id, name, email, password, "ADMIN", firstName, lastName);
    }
}
