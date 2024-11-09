package com.flipfit.bean;

public class GymManager extends Person{
    private String[] gym;

    public GymManager(String id, String name, String email, String password, String firstName, String lastName, String[] gym) {
        super(id, name, email, password, "GYM_OWNER", firstName, lastName);
        this.gym = gym;
    }

    public GymManager() {
        super("", "", "", "", "", "", "");
    }

    public String[] gym() {
        return gym;
    }

    public GymManager setGym(String[] gym) {
        this.gym = gym;
        return this;
    }

    public String[] getGym() {
        return gym;
    }
}
