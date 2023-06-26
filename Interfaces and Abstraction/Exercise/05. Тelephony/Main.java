package Telephony;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] numberData = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(Arrays.stream(numberData).collect(Collectors.toList()), Arrays.stream(urls).collect(Collectors.toList()));

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
