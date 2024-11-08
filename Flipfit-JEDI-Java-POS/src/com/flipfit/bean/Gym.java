package com.flipfit.bean;

public class Gym {
    private String gymId;
    private String regionId;
    private int pinCode;

    public String gymId() {
        return gymId;
    }

    public Gym setGymId(String gymId) {
        this.gymId = gymId;
        return this;
    }

    public String region() {
        return regionId;
    }

    public Gym setRegionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public int pinCode() {
        return pinCode;
    }

    public Gym setPinCode(int pinCode) {
        this.pinCode = pinCode;
        return this;
    }
}
