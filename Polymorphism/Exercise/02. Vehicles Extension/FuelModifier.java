package Polymorphism.Exercise.Vehicle;
public enum FuelModifier {

    CAR_AC_ADDITIONAL_CONSUMPTION(0.9),
    TRUCK_AC_ADDITIONAL_CONSUMPTION(1.6),
    TRUCK_TANK_FUEL_DEDUCTION(0.95),
    BUS_WITH_PASSENGERS_ADDITIONAL_CONSUMPTION(1.4);

    private double fuelModifier;

    FuelModifier(double fuelModifier) {
        this.fuelModifier = fuelModifier;
    }

    public double getFuelModifier() {
        return fuelModifier;
    }
}