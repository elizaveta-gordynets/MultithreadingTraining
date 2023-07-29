package syncEx;


public class SynchronizedWriter implements Runnable {

    private CommonRes res;

    @Override
    public void run() {
        res.check();
    }
}
