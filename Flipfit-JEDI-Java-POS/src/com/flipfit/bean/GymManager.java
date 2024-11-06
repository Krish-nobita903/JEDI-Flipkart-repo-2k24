package com.flipfit.bean;

public class GymManager extends Person{
    private Gym[] gym;

    public GymManager(String id, String name, String email, String password, String firstName, String lastName, Gym gym) {
        super(id, name, email, password, "GYM_OWNER", firstName, lastName);
    }

    public Gym[] gym() {
        return gym;
    }

    public GymManager setGym(Gym[] gym) {
        this.gym = gym;
        return this;
    }
}
