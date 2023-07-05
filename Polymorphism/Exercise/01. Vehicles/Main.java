package Polymorphism.Exercise.Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");
//        String[] busData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
//        Vehicle bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Integer.parseInt(busData[3]));
        Map<String, Vehicle> vehicles = new LinkedHashMap<>() {{
            put("Car", car);
            put("Truck", truck);
        }};
//        vehicles.put("Car", car);
//        vehicles.put("Truck", truck);
//        vehicles.put("Bus", bus);

        int commands = Integer.parseInt(scanner.nextLine());
        while (commands-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            if (command.equals("Drive")) {
                vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else if (command.equals("Refuel")) {
                vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
            }
//            } else if (command.equals("DriveEmpty")) {
//                vehicles.get(tokens[1]).driveEmpty(Double.parseDouble(tokens[2]));
//            }
        }

        vehicles.forEach((key, value) -> System.out.printf("%s: %.2f\n", key, value.getFuelQuantity()));
    }
}
