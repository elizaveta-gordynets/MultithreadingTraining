package syncEx.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DemoReader implements Runnable {

    private String treadName;
    private String fileName;
    private CyclicBarrier barrier;

    public DemoReader(String treadName, String fileName, CyclicBarrier barrier) {
        this.treadName = treadName;
        this.fileName = fileName;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Reading supposed file : " + fileName + " by thread " + treadName);

        try{
            barrier.await();
        } catch (InterruptedException |BrokenBarrierException e) {
            System.out.println(e.getMessage());
        }

    }
}
