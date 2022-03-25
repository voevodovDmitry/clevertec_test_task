package entities;

public class Item {
    private int id;
    private String name;
    private int price;
    private boolean isDiscount;


    public Item(int id, String name, int price, boolean isDiscount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscount = isDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isDiscount=" + isDiscount +
                '}';
    }
}
