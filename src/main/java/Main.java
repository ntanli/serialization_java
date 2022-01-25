import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Price[] prices = mapper.readValue(
                new File("C:\\Users\\79631\\Documents\\prices.txt"),
                Price[].class);

        HashMap<Integer, Integer> categoryAndPrice = new HashMap<>();

        categoryAndPrice.put(prices[0].getCategory_id(), prices[0].getPrice());

        for(int i = 0; i < prices.length; i++) {
            if (categoryAndPrice.containsKey(prices[i].getCategory_id())) {
                if (prices[i].getPrice() > categoryAndPrice.get(prices[i].getCategory_id())) {
                    categoryAndPrice.put(prices[i].getCategory_id(), prices[i].getPrice());
                }
            }else {
                categoryAndPrice.put(prices[i].getCategory_id(), prices[i].getPrice());
            }

            }
            for(Map.Entry<Integer, Integer> entry : categoryAndPrice.entrySet()) {
                System.out.println("Категория: " + entry.getKey());
                System.out.println("Максимальная цена: " + entry.getValue());

        }


    }
}
