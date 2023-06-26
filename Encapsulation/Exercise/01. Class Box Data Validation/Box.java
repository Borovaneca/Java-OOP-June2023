package Encapsulation.Exercise.ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            validation("Length");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            validation("Width");
        }
        this.width = width;
    }

    private static void validation(String prefix) {
        throw new IllegalStateException(String.format("%s cannot be zero or negative.", prefix));
    }

    private void setHeight(double height) {
        if (height <= 0) {
            validation("Height");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
