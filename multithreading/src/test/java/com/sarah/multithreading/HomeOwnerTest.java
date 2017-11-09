package com.sarah.multithreading;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import com.sarah.multithreading.App;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class HomeOwnerTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    House house;
    @Before
    public void setUp () {
        house = new House();
    }

    @Test
    public void testThread() throws Exception {
        logger.info("Just before creating a new runnable");
        HomeOwner myRunnable = new HomeOwner(house);
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();
    }

    @Test
    public void testThreadInterruption() throws Exception {
        HomeOwner runnable = new HomeOwner(house);
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException x) {
            throw new InterruptedException();
        }

        logger.info("Interrupting the other thread");
        thread.interrupt();
    }

}
