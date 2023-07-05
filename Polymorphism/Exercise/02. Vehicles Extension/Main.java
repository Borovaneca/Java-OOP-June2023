package Polymorphism.Exercise.Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, VehicleImpl> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        vehicleMap.put("Bus", getVehicle(scanner));

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];
            double argument = Double.parseDouble(commandParts[2]);

            switch (command) {
                case "Drive":
                    vehicleMap.get(vehicleType).setIsWithPassengers(true);
                    try {
                        vehicleMap.get(vehicleType).drive(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    vehicleMap.get(vehicleType).setIsWithPassengers(false);
                    try {
                        vehicleMap.get(vehicleType).drive(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Refuel":
                    try {
                        vehicleMap.get(vehicleType).refuel(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static VehicleImpl getVehicle(Scanner scanner) {

        String[] vehicleInput = scanner.nextLine().split("\\s+");

        String vehicleType = vehicleInput[0];
        double fuelQuantity = Double.parseDouble(vehicleInput[1]);
        double litersPerKm = Double.parseDouble(vehicleInput[2]);
        double tankCapacity = Double.parseDouble(vehicleInput[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, litersPerKm, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, litersPerKm, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, litersPerKm, tankCapacity);
            default:
                throw new IllegalArgumentException("Invalid vehicle type!");
        }
    }
}
