package Service;

import entities.DiscountCard;
import interfaces.APurchase;
import utility.Money;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptService {

        public  boolean isDiscountCardinReceipt(String[] args){

            Pattern pattern = Pattern.compile("card-[0-9]{4}");
            Matcher matcher = pattern.matcher(Arrays.toString(args));

            return matcher.find();

        }

        public void printReceipt (List<APurchase> purchaseList){

            int sum = 0;

            System.out.println(String.format("%30s", "CASH RECEIPT"));
            System.out.println(String.format("%30s", "Supermarket 123"));
            System.out.println(String.format("%35s", "12, Milkyway Galaxy / Earth"));
            System.out.println(String.format("%50s", LocalDate.now()));
            String pattern = " HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            System.out.println(String.format("%50s",  date));
            System.out.println("---------------------------------------------------------");

            for(APurchase purchase: purchaseList){
                sum += purchase.getCost();
                System.out.println(purchase);
            }
            System.out.println("---------------------------------------------------------");

            System.out.println(String.format("%50s", "sum= " + Money.toDollarCentForm(sum)));

        }

        public  void printReceiptWithDiscountCard(List<APurchase> purchaseList, DiscountCard card){
            int sum = 0;
            int discountedSum = 0;

            System.out.println(String.format("%30s", "CASH RECEIPT"));
            System.out.println(String.format("%30s", "Supermarket 123"));
            System.out.println(String.format("%35s", "12, Milkyway Galaxy / Earth"));
            System.out.println(String.format("%50s", LocalDate.now()));
            String pattern = " HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            System.out.println(String.format("%50s",  date));
            System.out.println("---------------------------------------------------------");


            for(APurchase purchase: purchaseList){
                sum += purchase.getCost();
                discountedSum = Money.calculatePercents(sum, card.getDiscountPercent());
                System.out.println(purchase);
            }
            System.out.println("---------------------------------------------------------");

            System.out.println("DiscountCard # " + card.getId());
            System.out.println("Discount by card  " + card.getDiscountPercent() + "%");
            System.out.println(String.format("%50s", "sum= " + Money.toDollarCentForm(sum)));
            System.out.println(String.format("%50s", "discountedSum= " + Money.toDollarCentForm(discountedSum)) );
            System.out.println(String.format("%50s", "TOTAL= " + Money.toDollarCentForm(sum - discountedSum) ));

    }
}
