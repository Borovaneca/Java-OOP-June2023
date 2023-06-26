package Encapsulation.Exercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] pizzaData = scanner.nextLine().split(" ");
        Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        String[] doughData = scanner.nextLine().split(" ");
        Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
        pizza.setDough(dough);
        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String[] toppingData = command.split(" ");
            Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
            pizza.addTopping(topping);
        }
        System.out.printf("%s - %.2f\n", pizza.getName(), pizza.getOverallCalories());
    }
}
