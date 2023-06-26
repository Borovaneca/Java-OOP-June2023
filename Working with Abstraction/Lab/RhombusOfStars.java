package WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);

        printMiddle(n);

        printBottom(n);
    }

    private static void printMiddle(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printBottom(int n) {
        for (int i = n -1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printTop(int n) {
        for (int i = 1; i <= n-1; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = n -i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
