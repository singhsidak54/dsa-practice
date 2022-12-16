package companies.Google;

import java.util.HashMap;
import java.util.TreeMap;

public class StockPriceFluctuation {

    HashMap<Integer, Integer> timestampMap;
    TreeMap<Integer, Integer> priceMap;
    int latestTimestamp;

    public StockPriceFluctuation() {
        latestTimestamp = Integer.MIN_VALUE;
        timestampMap = new HashMap<>();
        priceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        latestTimestamp = Math.max(latestTimestamp, timestamp);

        if(timestampMap.containsKey(timestamp)) {
            int oldPrice = timestampMap.get(timestamp);

            priceMap.put(oldPrice, priceMap.get(oldPrice) - 1);
            if(priceMap.get(oldPrice) == 0) {
                priceMap.remove(oldPrice);
            }
        }

        timestampMap.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timestampMap.get(latestTimestamp);
    }

    public int maximum() {
        return this.priceMap.lastKey();
    }

    public int minimum() {
        return this.priceMap.firstKey();
    }
}
