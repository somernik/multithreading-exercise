package com.sarah.multithreading;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Logger log = Logger.getLogger(App.class);
        log.info( "Start Trick or treating!");

        House house = new House();
        HomeOwner homeOwner = new HomeOwner(house);

        KidGenerator generator = new KidGenerator(house);

        Thread homeOwnerThread = new Thread(homeOwner);
        Thread generatorThread = new Thread(generator);

        generatorThread.start();
        homeOwnerThread.start();
    }
}
