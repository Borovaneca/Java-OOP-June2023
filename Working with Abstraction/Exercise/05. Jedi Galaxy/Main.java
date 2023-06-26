package WorkingWithAbstraction.Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowSize = dimensions[0];
        int colSize = dimensions[1];

        int[][] galaxy = new int[rowSize][colSize];

        int value = 0;
        fulFillGalaxy(rowSize, colSize, galaxy, value);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            evilPowerMoves(scanner, galaxy);

            sum = playerPath(galaxy, command, sum);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static void fulFillGalaxy(int rowSize, int colSize, int[][] galaxy, int value) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                galaxy[row][col] = value++;
            }
        }
    }

    private static long playerPath(int[][] galaxy, String command, long sum) {
        int[] playerPath = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();

        int playerRow = playerPath[0];
        int playerCol = playerPath[1];

        while (playerRow >= 0 && playerCol < galaxy[1].length) {
            if (isInBounce(galaxy, playerRow, playerCol)) {
                sum += galaxy[playerRow][playerCol];
            }

            playerCol++;
            playerRow--;
        }
        return sum;
    }

    private static boolean isInBounce(int[][] galaxy, int playerRow, int playerCol) {
        return playerRow >= 0 && playerRow < galaxy.length && playerCol >= 0 && playerCol < galaxy[0].length;
    }

    private static void evilPowerMoves(Scanner scanner, int[][] galaxy) {
        int[] evilPath = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int evilRow = evilPath[0];
        int evilCol = evilPath[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (isInBounce(galaxy, evilRow, evilCol)) {
                galaxy[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
