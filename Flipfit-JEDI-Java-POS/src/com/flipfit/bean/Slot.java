package com.flipfit.bean;

import java.util.Date;

public class Slot {
    private int id;
    private Gym gym;
    private String startTimeInUTC;
    private Date date;
    private int availableSeats;
    private String trainings;

    public int id() {
        return id;
    }

    public Slot setId(int id) {
        this.id = id;
        return this;
    }

    public Gym gym() {
        return gym;
    }

    public Slot setGym(Gym gym) {
        this.gym = gym;
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

    public String trainings() {
        return trainings;
    }

    public Slot setTrainings(String trainings) {
        this.trainings = trainings;
        return this;
    }

}
