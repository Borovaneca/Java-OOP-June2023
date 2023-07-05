package Polymorphism.Exercise.Vehicle;

public class Car extends Vehicle {

    private static final Double AIR_CONDITION_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double litersPerKM) {
        super(fuelQuantity, litersPerKM + AIR_CONDITION_CONSUMPTION);
    }
}
