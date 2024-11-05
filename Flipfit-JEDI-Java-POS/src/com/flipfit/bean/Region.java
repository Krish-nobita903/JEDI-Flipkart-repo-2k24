package com.flipfit.bean;

import java.util.List;

public class Region {
    private String regionName;
    private List<String> Gyms;

    public String regionName() {
        return regionName;
    }

    public Region setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public List<String> Gym() {
        return Gyms;
    }

    public Region setGym(List<String> gyms) {
        Gyms = gyms;
        return this;
    }
}
