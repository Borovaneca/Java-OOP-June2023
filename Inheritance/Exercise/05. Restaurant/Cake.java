package restaurant;

import java.math.BigDecimal;;

public class Cake extends Dessert {

    private static double CAKE_GRAMS = 250;
    private static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);
    private static double CAKE_CALORIES = 1000;

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
