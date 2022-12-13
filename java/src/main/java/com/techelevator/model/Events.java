package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Events {
    private int eventId;
    private LocalDate date;
    private LocalTime time;
    private int breweryId;
    private String description;


    public Events(){}

    public Events(int eventId, LocalDate date, LocalTime time, int breweryId, String description) {
        this.eventId = eventId;
        this.date = date;
        this.time = time;
        this.breweryId = breweryId;
        this.description = description;
    }



    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
