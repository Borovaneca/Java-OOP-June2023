package Polymorphism.Exercise.Vehicle;
import java.text.DecimalFormat;

import static Polymorphism.Exercise.Vehicle.FuelModifier.CAR_AC_ADDITIONAL_CONSUMPTION;


public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + CAR_AC_ADDITIONAL_CONSUMPTION.getFuelModifier()) > getFuelQuantity()) {
            throw new IllegalArgumentException("Car needs refueling");
        }

        setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + CAR_AC_ADDITIONAL_CONSUMPTION.getFuelModifier())));
        System.out.printf("Car travelled %s km\n", df.format(distance));
    }

    @Override
    public void refuel(double fuel) {

        if (fuel < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (getFuelQuantity() + fuel > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}