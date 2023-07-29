package syncEx;

//no prioritization


import java.util.concurrent.Semaphore;


public class ParkingSemaphoreEx {

    public static final boolean PARKING_LOTS[] = new boolean[5];
    public static final Semaphore SEMAPHORE = new Semaphore(5, true);


}
