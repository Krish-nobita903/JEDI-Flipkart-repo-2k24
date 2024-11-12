package com.flipfit.bean;

import java.util.List;

public class Region {

    private String regionId;
    private String regionName;
    private List<String> Gym;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
    public String regionName() {
        return regionName;
    }

    public Region setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

    public List<String> Gym() {
        return Gym;
    }

    public Region setGym(List<String> gym) {
        Gym = gym;
        return this;
    }
}
