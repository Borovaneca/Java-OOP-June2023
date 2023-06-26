package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String driver = scanner.nextLine();
        Ferrari drivedFerrari = new Ferrari(driver);
        System.out.println(drivedFerrari);
    }
}
