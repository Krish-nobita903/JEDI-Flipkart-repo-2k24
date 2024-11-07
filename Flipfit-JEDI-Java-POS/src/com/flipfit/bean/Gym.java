package com.flipfit.bean;

public class Gym {
    private String gymId;
    private String regionId;
    private int pinCode;

    public String gymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public Region region() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public int pinCode() {
        return pinCode;
    }

    public Gym setPinCode(int pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public int getPostalCode() {
        return pinCode;
    }

    public String getRegionId() {
        return regionId;
    }
}
