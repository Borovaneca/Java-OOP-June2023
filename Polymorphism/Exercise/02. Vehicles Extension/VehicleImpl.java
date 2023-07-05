package Polymorphism.Exercise.Vehicle;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double litersPerKm;

    private double tankCapacity;
    private boolean isWithPassengers;

    public VehicleImpl(double fuelQuantity, double litersPerKm, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
        setTankCapacity(tankCapacity);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getLitersPerKm() {
        return litersPerKm;
    }

    private void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected boolean isWithPassengers() {
        return isWithPassengers;
    }

    public void setIsWithPassengers(boolean isWithPassengers) {
        this.isWithPassengers = isWithPassengers;
    }
}
