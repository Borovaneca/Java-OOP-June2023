package carShop;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder outPut = new StringBuilder();

        outPut.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s sells for %f", getModel(), getPrice()));

        return outPut.toString();
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
