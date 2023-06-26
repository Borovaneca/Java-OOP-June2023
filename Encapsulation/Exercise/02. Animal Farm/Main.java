package Encapsulation.Exercise.AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int age = Integer.parseInt(br.readLine());
        Chicken chicken = null;
        try {
            chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IllegalStateException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
