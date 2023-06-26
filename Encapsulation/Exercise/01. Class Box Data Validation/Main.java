package Encapsulation.Exercise.ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(br.readLine());
        double width = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        Box box = null;
        try {
            box = new Box(length, width, height);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n", box.calculateVolume());

    }
}