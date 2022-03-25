package entities;

public class DiscountCard {
    private int id;
    private String cardholder;
    private int discountPercent;

    public DiscountCard() {
    }

    public DiscountCard(int id, String cardholder, int discountPercent) {
        this.id = id;
        this.cardholder = cardholder;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", cardholder='" + cardholder + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
