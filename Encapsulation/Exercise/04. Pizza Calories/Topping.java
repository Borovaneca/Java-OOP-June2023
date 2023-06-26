package Encapsulation.Exercise.PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;
    private double calories;

    public Topping(String toppingType, double wight) {
        setToppingType(toppingType);
        setWeight(wight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

        this.toppingType = toppingType;
        switch (this.toppingType) {
            case "Meat":
                setCalories(1.2);
                break;
            case "Veggies":
                setCalories(0.8);
                break;
            case "Cheese":
                setCalories(1.1);
                break;
            case "Sauce":
                setCalories(0.9);
                break;
        }
    }

    private void setWeight(double weight) {
        if (weight > 50 || weight < 1) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }


    public double calculateCalories() {
        return (2 * this.weight) * this.calories;
    }
}
