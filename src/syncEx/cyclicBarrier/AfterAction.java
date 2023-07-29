package syncEx.cyclicBarrier;

public class AfterAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Further data processing after all files were read");
    }
}
