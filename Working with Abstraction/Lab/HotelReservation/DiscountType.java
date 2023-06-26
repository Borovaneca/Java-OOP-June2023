package WorkingWithAbstraction.Lab.HotelReservation;

public enum DiscountType {
    NONE("None", 0),
    SECONDVISIT("SecondVisit", 10),
    VIP("VIP", 20);


    private String type;
    private double percent;


    DiscountType(String type, double percent) {
        this.type = type;
        this.percent = percent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
