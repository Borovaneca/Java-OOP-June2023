package InterfacePerson;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");
            String type = inputData[0];
            String name = null;
            String birthDate = null;
            switch (type) {
                case "Pet":
                    name = inputData[1];
                    birthDate = inputData[2];
                    Pet currentPet = new Pet(name, birthDate);
                    birthables.add(currentPet);
                    break;
                case "Citizen":
                    name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    birthDate = inputData[4];
                    Citizen currentCitizen = new Citizen(name, age, id, birthDate);
                    birthables.add(currentCitizen);
                    break;
            }


            input = scanner.nextLine();
        }

        String birthDayToSearchFor = scanner.nextLine();

        birthables.stream()
                .filter(item -> item.getBirthDate().contains(birthDayToSearchFor))
                .forEach(e -> System.out.println(e.getBirthDate()));


    }
}
