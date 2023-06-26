package WorkingWithAbstraction.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] rectangleData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bottomLeftX = rectangleData[0];
        int bottomLeftY = rectangleData[1];
        int topRightX = rectangleData[2];
        int topRightY = rectangleData[3];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int rotation = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotation; i++) {
            int[] pointToCheckData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int pointX = pointToCheckData[0];
            int pointY = pointToCheckData[1];
            Point pointToCheck = new Point(pointX, pointY);
            System.out.println(rectangle.contain(pointToCheck));
        }
    }
}
