package entities;


import interfaces.APurchase;
import utility.Money;

public class DiscountPurchase extends APurchase {
    static public final int LIMIT = 5;
    static public final int PERCENT = 10;
    private boolean isDiscount;

    public DiscountPurchase(boolean isDiscount) {
        this.isDiscount = isDiscount;
    }

    public DiscountPurchase(Item item, int quantity) {
        super(item, quantity);
    }



    @Override
    public int getCost() {
        if(getQuantity() >= LIMIT){
            isDiscount = true;
            int discountFactor = Money.calculatePercents(this.getItem().getPrice(), 100 - PERCENT);
            int result = discountFactor * getQuantity();
            return result;
        }
        return getQuantity() * this.getItem().getPrice();
    }

    @Override
    public String toString() {
        String str = String.format(
                "%-20s %-5s %-7s %-20s",
                this.getItem().getName(),
                this.getQuantity(),
                Money.toDollarCentForm(this.getItem().getPrice()),
                Money.toDollarCentForm(getCost()) + "" + (isDiscount ? ( " - discount " + PERCENT + "%") : ("") ));
        return    str;
    }
}
