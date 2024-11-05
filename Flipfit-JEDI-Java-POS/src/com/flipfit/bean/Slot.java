package com.flipfit.bean;

import java.util.Date;

public class Slot {
    private int slotId;
    private Gym gymId;
    private String startTimeInUTC;
    private Date date;
    private int availableSeats;
    private List<String> trainings;

    public int id() {
        return slotId;
    }

    public Slot setSlotId(int slotId) {
        this.slotId = slotId;
        return this;
    }

    public Gym gym() {
        return gymId;
    }

    public Slot setGymId(Gym gymId) {
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

    public List<String> trainings() {
        return trainings;
    }

    public List<String> setTrainings(List<String> trainings) {
        this.trainings = trainings;
        return this.trainings();
    }

}
