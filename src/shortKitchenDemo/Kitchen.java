/*
package shortKitchenDemo;

import shortKitchenDemo.etc.Order;
import shortKitchenDemo.food.Dish;
import shortKitchenDemo.staff.Chef;
import shortKitchenDemo.staff.Cook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Kitchen {

    List<Cook> cooks;
    Chef chef;
    private final Stove stove = new Stove();
    ExecutorService service = Executors.newFixedThreadPool(4);

    public Kitchen(List<Cook> cooks, Chef chef) {
        this.cooks = cooks;
        this.chef = chef;
    }

    public Set<Dish> startCookingProcess(List<Cook> cooks, Order order, Chef chef) {
        Queue<Dish> dishesToCook = new ArrayDeque<>();
        order.getOrderedDishes().values().stream().map(dishesToCook::offer);
        Set<Dish> finishedDishes = new HashSet<>();
        while (!dishesToCook.isEmpty()) {
            Dish toCook = dishesToCook.poll();
            int numberOfRequiredCooks = toCook.getStates().size();
            List<Cook> busyCooks = cooks.stream().limit(numberOfRequiredCooks).collect(Collectors.toList());

            Stack<Integer> availiableActionsToGive = new Stack<>();
            toCook.getStates().stream().map(s -> s.number).forEach(availiableActionsToGive::push);
            List<Future<?>> submitted = setActionsForCooks(busyCooks, availiableActionsToGive);
           if(submitted.stream().allMatch(Future::isDone)) {
               toCook.setFinished(true);
               finishedDishes.add(toCook);
            }
        }
        return finishedDishes;
    }


    public List<Future<?>> setActionsForCooks(List<Cook> busyCooks, Stack<Integer> actions) {
        List<Future<?>> submittedTasks = new ArrayList<>();
        while (!actions.isEmpty()) {
            busyCooks.stream().filter(c -> !c.isBusy()).forEach(cook -> {
                switch (actions.pop()) {
                    case 1:
                       submittedTasks.add(service.submit(() -> {
                            cook.boil();
                            cook.setBusy(true);
                        }));
                        break;
                    case 2:
                        submittedTasks.add(service.submit(() -> {
                            cook.fry();
                            cook.setBusy(true);
                        }));
                        break;
                    case 3:
                        submittedTasks.add(service.submit(() -> {
                            cook.chop();
                            cook.setBusy(true);
                            try {
                                Thread.currentThread().join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
                        break;
                    case 4:
                        submittedTasks.add(service.submit(() -> {
                            cook.bake();
                            cook.setBusy(true);
                        }));
                        break;
                    case 5:
                        submittedTasks.add(service.submit(() -> {
                            cook.addSpices();
                            cook.setBusy(true);
                        }));
                        break;
                    case 7:
                        submittedTasks.add(service.submit(() -> {
                            cook.addSause();
                            cook.setBusy(true);
                        }));
                        break;
                }
            });
        }
       return submittedTasks;
    }
}
*/
