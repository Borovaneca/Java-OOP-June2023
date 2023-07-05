package Polymorphism.Exercise.Vehicle;

import java.text.DecimalFormat;

public class Vehicle implements VehicleInterface {

    private double fuelQuantity;

//    public int getTankCapacity() {
//        return tankCapacity;
//    }
//
//    public void setTankCapacity(int tankCapacity) {
//        this.tankCapacity = tankCapacity;
//    }

//    private int tankCapacity;
    private double litersPerKM;

    public Vehicle(double fuelQuantity, double litersPerKM) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKM = litersPerKM;
//        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKM() {
        return litersPerKM;
    }

//    public void setLitersPerKM(double litersPerKM) {
//        this.litersPerKM = litersPerKM;
//    }
//
//    public void driveEmpty(double distance) {
//        if (this.getClass() == Bus.class) {
//            DecimalFormat df = new DecimalFormat("0.##");
//            double calcDistance = distance * getLitersPerKM();
//            if (calcDistance > getFuelQuantity()) {
//                System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
//            } else {
//                System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), df.format(distance));
//                setFuelQuantity(getFuelQuantity() - calcDistance);
//            }
//        }
//    }

    @Override
    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("0.##");
        double distanceCalc = distance * getLitersPerKM();
//        if (this.getClass() == Bus.class) {
//            distanceCalc = distance * (getLitersPerKM() + Bus.getAIR_CONDITION_ON());
//            if (distanceCalc > getFuelQuantity()) {
//                System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
//            } else {
//                System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), df.format(distance));
//                setFuelQuantity(getFuelQuantity() - distanceCalc);
//            }
//            return;
//        }
        if (distanceCalc > getFuelQuantity()) {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        } else if (distanceCalc <= getFuelQuantity()){
            System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), df.format(distance));
            setFuelQuantity(getFuelQuantity() - distanceCalc);
        }

    }

    @Override
    public void refuel(double liters) {
        double refuelCalc = liters;
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
//        } else if (liters + getFuelQuantity() > getTankCapacity()) {
//            System.out.println("Cannot fit fuel in tank");
//            return;
//        }

        if (this.getClass() == Car.class){
            setFuelQuantity(getFuelQuantity() + liters);
        } else if (this.getClass() == Truck.class) {
            refuelCalc = liters - (liters * ((Truck) this).getTINY_WHOLE_LOSES());
            setFuelQuantity(getFuelQuantity() + refuelCalc);
        }

    }
}
