package com.flipfit.bean;

public class Gym {
    private String gymId;
    private String regionId;
    private int pinCode;
    //private String gymName;

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

    //public String gymName() {return gymName;}

//    public Gym setGymName(String gymName) {
//        this.gymName = gymName;
//        return this;
//    }
}