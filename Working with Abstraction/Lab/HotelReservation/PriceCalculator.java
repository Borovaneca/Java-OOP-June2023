package WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator {


    public static double calculateHolidayPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        double sumPrice = pricePerDay * numberOfDays;
        sumPrice *= season.getCoefficient();
        sumPrice = sumPrice - sumPrice * discountType.getPercent() / 100;

        return sumPrice;
    }
}
