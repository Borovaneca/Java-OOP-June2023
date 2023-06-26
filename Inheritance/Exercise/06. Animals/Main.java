package animals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Animal> animalMap = new LinkedHashMap<>();


        String inputData = scanner.nextLine();

        while (!"Beast!".equals(inputData)) {

            try {

                fillTypeData(inputData, scanner.nextLine().split("\\s+"), animalMap);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


            inputData = scanner.nextLine();
        }

        for (Map.Entry<String, Animal> animal : animalMap.entrySet()) {
            System.out.println(animal.getValue());
        }

    }

    public static void fillTypeData(String prefix, String[] inputData, LinkedHashMap<String, Animal> animalMap) {
        String name = null;
        int age = -1;
        String gender = null;
        switch (prefix) {
            case "Cat":
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                gender = inputData[2];
                Cat currentCat = new Cat(name, age, gender);
                animalMap.put(prefix, currentCat);
                break;
            case "Kitten":
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                Kitten currentKitten = new Kitten(name, age);
                animalMap.put(prefix, currentKitten);
                break;
            case "Tomcat":
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                Tomcat currentTomcat = new Tomcat(name, age);
                animalMap.put(prefix, currentTomcat);
                break;
            case "Dog":
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                gender = inputData[2];
                Dog currentDog = new Dog(name, age, gender);
                animalMap.put(prefix, currentDog);
                break;
            case "Frog":
                name = inputData[0];
                age = Integer.parseInt(inputData[1]);
                gender = inputData[2];
                Frog currentFrog = new Frog(name, age, gender);
                animalMap.put(prefix, currentFrog);
                break;
        }
    }
}
