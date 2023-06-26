package Encapsulation.Exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setToppings(int toppings) {
            if (toppings < 0 || toppings > 10) {
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }
        this.toppings = new ArrayList<>(toppings);
    }

    private void setName(String name) {
            if (name.trim().isEmpty() || name.length() > 15) {
                throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
            }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() == this.numberOfToppings) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double calcToppings = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
//        for (Topping topping : toppings) {
//     calcToppings += topping.calculateCalories();
// }
        return this.dough.calculateCalories() + calcToppings;
    }
}
