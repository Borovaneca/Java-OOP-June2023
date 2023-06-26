package borderControl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Identifiable> checked = new LinkedHashMap<>();


        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] inputData = input.split("\\s+");
            String nameOrModel = inputData[0];
            if (inputData.length == 3) {
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                Identifiable citizen = new Citizen(nameOrModel, age, id);
                checked.put(id, citizen);
            } else {
                String id = inputData[1];
                Identifiable robot = new Robot(nameOrModel, id);
                checked.put(id, robot);
            }
        }

        String fakeIdContains = scanner.nextLine();

        checked.keySet().stream().filter(item -> item.endsWith(fakeIdContains)).forEach(System.out::println);
    }
}
