package Shape;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Shape(Double perimeter, Double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();
}
