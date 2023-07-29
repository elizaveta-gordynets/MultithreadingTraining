package syncEx;


import java.util.concurrent.locks.ReentrantLock;

public class CommonRes {

    ReentrantLock lock = new ReentrantLock();
    int counter = 1;

    public void check() {
       boolean acquired = lock.tryLock();
       if(acquired) {
           try {
               for (int i = 0; i < 10; i++) {
                   System.out.println(counter++);
               }
           } finally {
               lock.unlock();
           }
       } else {

       }
    }

}
