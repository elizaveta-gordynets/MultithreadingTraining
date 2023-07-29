import restaurantDemo.Dish;
import restaurantDemo.Kitchen;
import restaurantDemo.Order;
import restaurantDemo.States;
import syncEx.cyclicBarrier.AfterAction;
import syncEx.cyclicBarrier.DemoReader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static volatile Integer varToPass = 0;

    public static int x = 0;
    public static volatile boolean y = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Kitchen kitchen = new Kitchen();
        Map<String, Dish> ordered = new HashMap<>();
        ordered.put("Puree", new Dish("Puree", List.of("Potato", "Cream", "Salt"), List.of( States.CHOPPED, States.BOLED, States.WITH_SPICES)));
        ordered.put("Apple Tart", new Dish("Apple Tart", List.of("Base", "Cream", "Lemons","Sugar"),
                List.of(States.CHOPPED, States.BAKED)));
        ordered.put("Fried Meat", new Dish("Fried Meat", List.of("Meat", "Salt", "Spices", "Sause"), List.of(States.CHOPPED,
                States.FRIED, States.WITH_SPICES, States.WITH_SAUCE)));
        Order order = new Order(ordered);
        kitchen.startCookingProcess(order);



/*
       CyclicBarrier barrier = new CyclicBarrier(3, new AfterAction());
        Thread first = new Thread(new DemoReader("First", "SomeFile.txt", barrier));
        Thread second = new Thread(new DemoReader("Second", "SomeFile1.txt", barrier));
        Thread third = new Thread(new DemoReader("Third", "SomeFile2.txt", barrier));
        first.start();
        second.start();
        third.start();

Thread.sleep(1000);
        System.out.println("Setting new set of therads");
        Thread forth = new Thread(new DemoReader("Forth", "SomeFile.txt", barrier));
        Thread fifth = new Thread(new DemoReader("Fifth", "SomeFile1.txt", barrier));
        Thread sixthd = new Thread(new DemoReader("Sixths", "SomeFile2.txt", barrier));
        forth.start();
        fifth.start();
        sixthd.start();*/




    /*    CommonRes res = new CommonRes();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(res::check);
            t.start();
        }*//*

      ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        Iterator<Map.Entry<Integer, String >> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            map.put(2, "2");
            iterator.next();
        }
/*

        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> System.out.println("Im done"));
        executor.execute(() -> System.out.println("NOOOO"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future< Integer> result = multiply(5, executorService);
        Integer res = result.get();
        System.out.println(res);
        Future<Integer> sumRes = sum(res, executorService);
        Integer secondRes = sumRes.get();
        System.out.println(secondRes);
        executorService.shutdown();


        //System.out.println(coll.size());

   *//*     Counter counter = new Counter();
       Thread t1 = new Thread(() -> {
           for (int i = 0; i < 5000; i++) {
               counter.incrementCunter();
           }
           varToPass = counter.getInteger();
       });
       Thread t2 = new Thread(() -> {
           for (int i = 0; i < 5000; i++) {
               counter.incrementCunter();
           }
           varToPass = counter.getInteger();
       });

       t1.start();
       t2.start();
       t1.join();*//*
//Thread.sleep(500);
      //  System.out.println(varToPass);


        *//* This is the way to schedule tasks daily/monthly/hourly/weekly etc*//*
       *//* ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> task= executorService.scheduleAtFixedRate(() -> {
            System.out.println("This is somtheimg going on scheduled");
        }, 10, 5,  TimeUnit.SECONDS);
        System.out.println(task.get());
        executorService.shutdown();*//*

        *//*ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future task = executorService.submit(() -> System.out.println("Somethng"));

        executorService.shutdown();
*/
    }

    public static Future<Integer> multiply(Integer res, ExecutorService executorService) {
        return executorService.submit(() -> {
                Thread.sleep(10000);
                return res*res;
        });
    }

    public static Future<Integer> sum (Integer res, ExecutorService service) {
        return service.submit(() -> res + 25);
    }
}
