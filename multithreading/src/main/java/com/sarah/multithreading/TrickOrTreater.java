package com.sarah.multithreading;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by sarah on 11/7/2017.
 */
public class TrickOrTreater implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());

    String name;
    Date inTime;
    House house;

    public TrickOrTreater(House house) {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run() {
        goTrickOrTreating();
    }

    private synchronized void goTrickOrTreating() {
        house.add(this);
    }
}
