package restaurantDemo;

import java.util.Map;

public class Order {

   private Map<String, Dish> orderedDishes;

    public Order(Map<String, Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public Map<String, Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(Map<String, Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
