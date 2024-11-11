package com.flipfit.bean;

import java.sql.Date;

public class Slot {
    private String slotId;
    private String gymId;
    private String startTimeInUTC;
    private Date date;
    private int availableSeats;
    private String training;

    public Slot() {

    }

    public Slot(String slotId, String gymId, String startTimeInUTC, Date date, int availableSeats, String training) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.startTimeInUTC = startTimeInUTC;
        this.date = date;
        this.availableSeats = availableSeats;
        this.training = training;
    }
    public String id() {
        return slotId;
    }

    public Slot setSlotId(String slotId) {
        this.slotId = slotId;
        return this;
    }

    public String gym() {
        return gymId;
    }

    public Slot setGymId(String gymId) {
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

    public String getSlotId() {
        return slotId;
    }

    public String getGymId() {
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