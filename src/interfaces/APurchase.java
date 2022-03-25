package interfaces;

import entities.Item;
import utility.Money;

public abstract class APurchase {
    private Item item;
    private int quantity;

    public APurchase() {
    }

    public APurchase(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost(){
        return quantity * getItem().getPrice();
    }

    public String getCostInDollarCentForm(){
        return Money.toDollarCentForm(quantity * getItem().getPrice());
    }

    @Override
    public String toString() {
        String str = String.format(
                "%-20s %-5s %-7s %-20s",
                this.getItem().getName(),
                this.getQuantity(),
                Money.toDollarCentForm(this.getItem().getPrice()),
                Money.toDollarCentForm(getCost()));
        return    str;
    }


}
