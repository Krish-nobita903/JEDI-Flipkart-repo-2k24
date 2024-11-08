package com.flipfit.bean;

public class Gym {
    private int gymId;
    private Region regionId;
    private int pinCode;

    public int gymId() {
        return gymId;
    }

    public Gym setGymId(int gymId) {
        this.gymId = gymId;
        return this;
    }

    public Region region() {
        return regionId;
    }

    public Gym setRegionId(Region regionId) {
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
