package com.flipfit.dao;

import com.flipfit.bean.Gym;

import java.util.List;

public interface RegionDAOInterface {
    public List<Gym> findGyminRegion(int pinCode);
}
