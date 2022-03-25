package Service;

import entities.DiscountCard;
import entities.Item;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataService {
    public Map<Integer, Item> initItemMap(String file){
        HashMap<Integer, Item> itemHashMap = new HashMap<>();
        try {
            Scanner sc = new Scanner(new FileReader(file));
            String line = null;
            String[] words = null;
            Item item = null;
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                words = line.split(" ");

                item = new Item(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]), Boolean.parseBoolean(words[3]) );

                itemHashMap.put(item.getId(), item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemHashMap;
    }

    public Map<Integer, DiscountCard> initCardMap(String file){
        ArrayList<DiscountCard> tempCardtList = new ArrayList<>();
        HashMap<Integer, DiscountCard> discountCardHashMap = new HashMap<>();
        try {
            Scanner sc = new Scanner(new FileReader(file));
            String line = null;
            String[] words = null;
            DiscountCard card = null;
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                words = line.split(" ");

                card = new DiscountCard(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]));

                discountCardHashMap.put(card.getId(), card);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return discountCardHashMap;
    }
}
