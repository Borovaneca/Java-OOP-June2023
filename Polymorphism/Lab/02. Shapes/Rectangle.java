package Shape;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double perimeter, Double area, Double height, Double width) {
        super(perimeter, area);
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        if (getPerimeter() == null) {
            setPerimeter(2 * (width + height));
        }
        return getPerimeter();
    }

    @Override
    protected Double calculateArea() {
        if (getArea() == null) {
            setArea(height * width);
        }
        return getArea();
    }
}
