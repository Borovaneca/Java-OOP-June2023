package Polymorphism.Exercise.Vehicle;

import java.text.DecimalFormat;

import static Polymorphism.Exercise.Vehicle.FuelModifier.TRUCK_AC_ADDITIONAL_CONSUMPTION;
import static Polymorphism.Exercise.Vehicle.FuelModifier.TRUCK_TANK_FUEL_DEDUCTION;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * (getLitersPerKm() + TRUCK_AC_ADDITIONAL_CONSUMPTION.getFuelModifier()) > getFuelQuantity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        }

        setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + TRUCK_AC_ADDITIONAL_CONSUMPTION.getFuelModifier())));
        System.out.printf("Truck travelled %s km\n", df.format(distance));
    }

    @Override
    public void refuel(double fuel) {

        if (fuel < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (getFuelQuantity() + fuel > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setFuelQuantity(getFuelQuantity() + (fuel * TRUCK_TANK_FUEL_DEDUCTION.getFuelModifier()));
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
