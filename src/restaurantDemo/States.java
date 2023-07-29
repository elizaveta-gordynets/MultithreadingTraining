package restaurantDemo;

public enum States {

    BOLED("Bolied", 1), FRIED("Fried", 2), CHOPPED("Chopped", 3),
    BAKED("Baked", 4), WITH_SPICES ("WithSpices", 5), WITH_SAUCE("WithSauce", 6);

   public final int number;
   public final String state;


    States(String state, int number) {
        this.number = number;
        this.state = state;
    }

}
