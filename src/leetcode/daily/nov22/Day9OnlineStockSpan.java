package daily.nov22;

import java.util.ArrayList;
import java.util.List;

public class Day9OnlineStockSpan {

    List<Integer> stockPrices;
    List<Integer> indexDaysMap;
    public Day9OnlineStockSpan() {
        stockPrices = new ArrayList<>();
        indexDaysMap = new ArrayList<>();
    }


    public int next(int price) {
        int size = stockPrices.size();
        if(size == 0) {
            stockPrices.add(price);
            indexDaysMap.add(1);
            return 1;
        } else {
            int curr = stockPrices.get(size - 1), currIndex = size - 1;
            int ans = 1;
            while (price >= curr) {
                int prevDaysGreater = indexDaysMap.get(currIndex);
                ans += prevDaysGreater;
                currIndex = currIndex - prevDaysGreater;
                if(currIndex < 0) {
                    break;
                }
                curr = stockPrices.get(currIndex);
            }
            stockPrices.add(price);
            indexDaysMap.add(ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        Day9OnlineStockSpan obj = new Day9OnlineStockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(80));
    }
}
