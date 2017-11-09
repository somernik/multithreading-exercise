package com.sarah.multithreading;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sarah on 11/7/2017.
 */
public class KidGenerator implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());
    House house;

    public KidGenerator(House house) {
        this.house = house;
    }

    public void run() {
        while(true) {
            TrickOrTreater trickOrTreater = new TrickOrTreater(house);
            trickOrTreater.setInTime(new Date());
            Thread thread = new Thread(trickOrTreater);
            trickOrTreater.setName("Trick or treater thread: " + thread.getId());
            thread.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            } catch (InterruptedException iex) {
                log.error("Error: ", iex);
            }
        }
    }

}
