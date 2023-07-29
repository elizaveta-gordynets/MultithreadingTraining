package restaurantDemo;

import java.util.List;

public class Dish {

    private List<String> ingredients;
    private String name;
    private boolean isFinished;
    private List<States> states;

    public Dish(String name, List<String> ingredients, List<States> states) {
        this.ingredients = ingredients;
        this.name = name;
        this.states = states;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }

}
