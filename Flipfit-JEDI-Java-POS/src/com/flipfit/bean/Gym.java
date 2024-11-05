package com.flipfit.bean;

public class Gym {
    private int gymId;
    private Region regionId;
    private int pinCode;
    private Slot[] slotsAvailable;

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

    public Slot[] slot() {
        return slotsAvailable;
    }

    public Gym setSlotsAvailable(Slot[] slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
        return this;
    }
}
