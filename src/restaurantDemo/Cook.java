package restaurantDemo;

public class Cook {

    private String name;
    private String specialization;
    private boolean isBusy;
    private Dish dishToCook;

    public Cook(String name) {
        this.name = name;
    }

    public void addSpices() {
        System.out.println("I'm adding spices to " + dishToCook.getName());
    }

    public void addSause() {
        System.out.println("I'm adding sause to " + dishToCook.getName());
    }

    public void boil() {
        System.out.println("I'm boiling " + dishToCook.getName());
    }

    public void fry() {
        System.out.println("I'm frying " + dishToCook.getName());
    }

    public void bake() {
        System.out.println("I'm baking " + dishToCook.getName());
    }

    public void chop() {
        System.out.println("I'm chopping " + dishToCook.getName());
    }


    public Dish getDishToCook() {
        return dishToCook;
    }

    public void setDishToCook(Dish dishToCook) {
        this.dishToCook = dishToCook;
    }
}
