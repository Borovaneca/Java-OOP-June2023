package carShop;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }



    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder outPut = new StringBuilder();

        outPut.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Minimum rental period is %s days. Price per day %f", getMinRentDay(), getPricePerDay()));
        return outPut.toString();
    }
}
