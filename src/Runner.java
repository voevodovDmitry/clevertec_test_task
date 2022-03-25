import Service.DataService;
import entities.DefaultPurchase;
import entities.DiscountCard;
import entities.DiscountPurchase;
import entities.Item;
import interfaces.APurchase;
import Service.ReceiptService;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        final String ITEMS_FILE_NAME = "./src/items.txt";
        final String CARDS_FILE_NAME = "./src/cards.txt";
        List<Item> itemList = null;
        ReceiptService receiptService = new ReceiptService();
        DataService dataService = new DataService();


        Map<Integer, DiscountCard> cardMap = dataService.initCardMap(CARDS_FILE_NAME);
        Map<Integer, Item> itemMap = dataService.initItemMap(ITEMS_FILE_NAME);

        buildPurchaseList(args, itemMap, cardMap);

    }

    private static  void buildPurchaseList(String[] args, Map<Integer, Item> itemMap, Map<Integer, DiscountCard> cardMap){
        Iterator iterator = Arrays.stream(args).iterator();
        ReceiptService receiptService = new ReceiptService();
        List<APurchase> purchaseList = new ArrayList<>();
        DiscountCard discountCard = null;

        while (iterator.hasNext()) {
            String line = (String) iterator.next();
            if (line.length() == 3) {
                String[] items = line.split("-");
                int key = Integer.parseInt(items[0]);
                int quantity = Integer.parseInt(items[1]);
                APurchase purchase = itemMap.get(key).isDiscount()
                        ? new DiscountPurchase(itemMap.get(key), quantity)
                        : new DefaultPurchase(itemMap.get(key), quantity);
                purchaseList.add(purchase);
            }
            if (line.length() == 9) {
                String[] items = line.split("-");
                int cardNumber = Integer.parseInt(items[1]);
                discountCard = cardMap.get(cardNumber);
            }
        }

        if(receiptService.isDiscountCardinReceipt(args)){
            receiptService.printReceiptWithDiscountCard(purchaseList, discountCard);
        }
        else{
            receiptService.printReceipt(purchaseList);
        }

    }


}
