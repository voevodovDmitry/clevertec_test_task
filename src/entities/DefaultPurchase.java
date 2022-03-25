package entities;


import interfaces.APurchase;

public class DefaultPurchase extends APurchase {


    public DefaultPurchase() {
    }

    public DefaultPurchase(Item item, int quantity) {
        super(item, quantity);
    }
}
