package utility;

public class Money {

    public static String toDollarCentForm(int moneyValue) {
        return (String)("$" + moneyValue/100 + "." + moneyValue%100/10 + moneyValue%100%10);
    }

    public static int calculatePercents(int moneyValue, int percent) {
        return (int) (moneyValue * percent / 100.0);
    }
}
