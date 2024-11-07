package com.flipfit.bean;

public class GymManager extends Person {
    private Gym[] gyms;  // Array of gyms

    public GymManager(String id, String name, String email, String password, String firstName, String lastName, Gym[] gyms) {
        super(id, name, email, password, "GYM_OWNER", firstName, lastName);
        this.gyms = gyms;  // Set the gyms array
    }

    public Gym[] getGyms() {
        return gyms;
    }

    public GymManager setGyms(Gym[] gyms) {
        this.gyms = gyms;
        return this;
    }
}
