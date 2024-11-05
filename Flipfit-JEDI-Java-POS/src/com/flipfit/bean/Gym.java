package com.flipfit.bean;

public class Gym {
    private int gymId;
    private Region region;
    private int pinCode;
    private Slot[] slot;
    private String country;

    public int gymId() {
        return gymId;
    }

    public Gym setGymId(int gymId) {
        this.gymId = gymId;
        return this;
    }

    public Region region() {
        return region;
    }

    public Gym setRegion(Region region) {
        this.region = region;
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
        return slot;
    }

    public Gym setSlot(Slot[] slot) {
        this.slot = slot;
        return this;
    }

    public String country() {
        return country;
    }

    public Gym setCountry(String country) {
        this.country = country;
        return this;
    }
}
