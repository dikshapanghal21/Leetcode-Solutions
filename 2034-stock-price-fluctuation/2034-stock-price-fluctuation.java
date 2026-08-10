import java.util.*;

class StockPrice {

    HashMap<Integer, Integer> map;
    TreeMap<Integer, Integer> prices;
    int latest;

    public StockPrice() {
        map = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            prices.put(oldPrice, prices.get(oldPrice) - 1);

            if (prices.get(oldPrice) == 0) {
                prices.remove(oldPrice);
            }
        }

        map.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0) + 1);

        latest = Math.max(latest, timestamp);
    }

    public int current() {
        return map.get(latest);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}