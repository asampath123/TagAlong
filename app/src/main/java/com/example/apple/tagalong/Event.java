package com.example.apple.tagalong;

import java.util.Date;

/**
 * Created by apple on 2/22/17.
 */

public class Event {

    public String eventName;
    public String location;
    public String description;

    public Date eventDate;

    public Date eventTime;

    public Event(String eventName, String location, String description, Date eventDate) {
        this.eventName = eventName;
        this.location = location;
        this.description = description;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesciption() {
        return description;
    }

    public void setDesciption(String desciption) {
        this.description = desciption;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }


}
