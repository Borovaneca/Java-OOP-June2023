package Shape;

public class Circle extends Shape {

    private Double radius;
    public Circle(Double perimeter, Double area, Double radius) {
        super(perimeter, area);
        setRadius(radius);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        if (getPerimeter() == null) {
            setPerimeter(2 * Math.PI * radius);
        }
        return getPerimeter();
    }

    @Override
    protected Double calculateArea() {
        if (getArea() == null) {
            setArea(Math.PI * radius * radius);
        }
        return getArea();
    }
}
