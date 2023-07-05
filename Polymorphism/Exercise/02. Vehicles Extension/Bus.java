package Polymorphism.Exercise.Vehicle;
import java.text.DecimalFormat;

import static Polymorphism.Exercise.Vehicle.FuelModifier.BUS_WITH_PASSENGERS_ADDITIONAL_CONSUMPTION;

public class Bus extends VehicleImpl {

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {

        DecimalFormat df = new DecimalFormat("#.##");

        if (isWithPassengers() && distance * (getLitersPerKm() + BUS_WITH_PASSENGERS_ADDITIONAL_CONSUMPTION.getFuelModifier()) > getFuelQuantity()) {
            printError("Bus needs refueling");
        }

        if (!isWithPassengers() && distance * getLitersPerKm() > getFuelQuantity()) {
            printError("Bus needs refueling");
        }

        if (isWithPassengers()) {
            setFuelQuantity(getFuelQuantity() - (distance * (getLitersPerKm() + BUS_WITH_PASSENGERS_ADDITIONAL_CONSUMPTION.getFuelModifier())));
        } else {
            setFuelQuantity(getFuelQuantity() - (distance * getLitersPerKm()));
        }

        System.out.printf("Bus travelled %s km\n", df.format(distance));
    }

    @Override
    public void refuel(double fuel) {

        if (fuel < 1) {
            printError("Fuel must be a positive number");
        }

        if (getFuelQuantity() + fuel > getTankCapacity()) {
            printError("Cannot fit fuel in tank");
        }

        setFuelQuantity(getFuelQuantity() + fuel);
    }

    private static void printError(String message) {
        throw new IllegalArgumentException(message);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
