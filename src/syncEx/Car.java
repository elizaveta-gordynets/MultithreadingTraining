package syncEx;


import static syncEx.ParkingSemaphoreEx.PARKING_LOTS;
import static syncEx.ParkingSemaphoreEx.SEMAPHORE;

public class Car implements Runnable {

    private int carNum;

    public Car(int carNum) {
        this.carNum = carNum;
    }

    @Override
    public void run() {
        System.out.printf("Car N%d came to parking lot \n", carNum);
        try {
            SEMAPHORE.acquire();
            int parkingNum = -1;

            synchronized (PARKING_LOTS) {
                for (int i = 0; i < 5; i++) {
                    if (!PARKING_LOTS[i]) {
                        PARKING_LOTS[i] = true;
                        parkingNum = i;
                        System.out.printf("Can N%d is parked \n", carNum);
                        break;
                    }
                }
            }
            Thread.sleep(5000);

            synchronized (PARKING_LOTS) {
                PARKING_LOTS[parkingNum] = false;
            }

            SEMAPHORE.release();
            System.out.printf("Car N%d has left the parking \n", carNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
}
