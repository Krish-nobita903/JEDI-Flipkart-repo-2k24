package com.flipfit.bean;

import java.util.Date;
import java.util.List;

public class Slot {
    private int slotId;
    private int gymId;
    private String startTimeInUTC;
    private Date date;
    private int availableSeats;
    private String training;

    public Slot() {

    }

    public Slot(int slotId, int gymId, String startTimeInUTC, Date date, int availableSeats, String training) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.startTimeInUTC = startTimeInUTC;
        this.date = date;
        this.availableSeats = availableSeats;
        this.training = training;
    }
    public int id() {
        return slotId;
    }

    public Slot setSlotId(int slotId) {
        this.slotId = slotId;
        return this;
    }

    public int gym() {
        return gymId;
    }

    public Slot setGymId(int gymId) {
        this.gymId = gymId;
        return this;
    }

    public String startTimeInUTC() {
        return startTimeInUTC;
    }

    public Slot setStartTimeInUTC(String startTimeInUTC) {
        this.startTimeInUTC = startTimeInUTC;
        return this;
    }

    public Date date() {
        return date;
    }

    public Slot setDate(Date date) {
        this.date = date;
        return this;
    }

    public int availableSeats() {
        return availableSeats;
    }

    public Slot setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
        return this;
    }

    public String training() {
        return training;
    }

    public String setTraining(String training) {
        this.training = training;
        return this.training();
    }

    public int getSlotId() {
        return slotId;
    }

    public int getGymId() {
        return gymId;
    }

    public String getStartTimeInUTC() {
        return startTimeInUTC;
    }

    public Date getDate() {
        return date;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getTraining() {
        return training;
    }
}
