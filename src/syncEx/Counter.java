package syncEx;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final AtomicInteger integer = new AtomicInteger(0);

    public void incrementCunter() {
        integer.incrementAndGet();
    }

    public  AtomicInteger getInteger() {
        return integer;
    }
}
