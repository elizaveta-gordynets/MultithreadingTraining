package restaurantDemo;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Kitchen {

    private List<Cook> cooks = List.of(new Cook("Steve"), new Cook("Maeve"),
            new Cook("Diana"), new Cook("Norm"), new Cook("Alan"));
    private Stove stove = new Stove(2);
    ExecutorService executorService = Executors.newScheduledThreadPool(4);


    public void startCookingProcess(Order order) throws InterruptedException, ExecutionException {
        int numberOfDishesToCook = order.getOrderedDishes().size();
        Queue<Cook> requiredForCooking = cooks.stream()
                .limit(numberOfDishesToCook)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Queue<Dish> dishesToCook = new ArrayDeque<>(order.getOrderedDishes().values());

        while (!requiredForCooking.isEmpty() && !dishesToCook.isEmpty()) {
            Cook currentCook = requiredForCooking.poll();
            currentCook.setDishToCook(dishesToCook.poll());

            Queue<States> stagesOfCooking = new ArrayDeque<>(currentCook.getDishToCook().getStates());

            while (!stagesOfCooking.isEmpty()) {
                States current = stagesOfCooking.poll();
                if (current.equals(States.CHOPPED)) {
                    Thread t = new Thread(currentCook::chop);
                    t.start();
                    t.join();
                }
                if (current.equals(States.FRIED) || current.equals(States.BOLED) || current.equals(States.BAKED)) {
                    executorService.submit(() -> {
                        try {
                            useTheStove(currentCook, currentCook.getDishToCook());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                } else if (current.equals(States.WITH_SPICES)) {
                    executorService.submit(currentCook::addSpices);
                } else {
                    executorService.submit(currentCook::addSause);
                }
            }
        }
        executorService.shutdown();
    }


    private void useTheStove(Cook cook, Dish dish) throws InterruptedException {
        if (stove.getAvailiableSpots() > 0) {
            if (stove.tryToCook()) {
                if (dish.getStates().contains(States.FRIED)) {
                    cook.fry();
                } else if (dish.getStates().contains(States.BOLED)) {
                    cook.boil();
                } else {
                    cook.bake();
                }
                Thread.sleep(5000);
            }
        }
    }

}
