package com.sarah.multithreading;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sarah on 11/7/2017.
 */
public class House {
    private final Logger log = Logger.getLogger(this.getClass());
    int nMaxSpots;
    List<TrickOrTreater> trickOrTreaterList;

    public House() {
        nMaxSpots = 10;
        trickOrTreaterList = new LinkedList<TrickOrTreater>();
    }

    public void giveCandy() {
        TrickOrTreater trickOrTreater;

        synchronized (trickOrTreaterList) {
            while(trickOrTreaterList.size()==0){
                log.info("Riley is watching tv");
                try {
                    trickOrTreaterList.wait();
                } catch (InterruptedException iex) {
                    log.error("Error: ", iex);
                }
            }
            log.info("Riley answers door");
            trickOrTreater = (TrickOrTreater)((LinkedList<?>)trickOrTreaterList).poll();

        }
        //long duration = 0;
        try {
            log.info("Riley gives candy");
            //duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(3);

        } catch(InterruptedException iex) {
            log.error("Error: ", iex);
        }
        log.info("Riley finished giving out candy to trick or treater:" + trickOrTreater.getName());
    }

    public void add (TrickOrTreater trickOrTreater) {
        log.info(trickOrTreater.getName() + " rings doorbell at " + trickOrTreater.getInTime());
        synchronized (trickOrTreaterList) {
            if (trickOrTreaterList.size() == nMaxSpots){
                log.info("No space available for trick or treater, they are moving on: " + trickOrTreater.getName());

                return;
            }

            ((LinkedList<TrickOrTreater>)trickOrTreaterList).offer(trickOrTreater);
            log.info(trickOrTreater.getName() + " is waiting for candy");

            if (trickOrTreaterList.size() == 1) {
                trickOrTreaterList.notify();
            }
        }
    }
}
