package com.sarah.multithreading;

import org.apache.log4j.Logger;

/**
 * Created by sarah on 11/7/2017.
 */
public class HomeOwner implements Runnable {
    House house;
    private final Logger log = Logger.getLogger(this.getClass());


    public HomeOwner(House house) {
        this.house = house;
    }

    public void run () {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley watching tv");

        while(true) {
            house.giveCandy();
        }
    }
}
