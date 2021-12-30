package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < minTillNow) {
                minTillNow = prices[i];
            } else if(prices[i] - minTillNow > maxProfit)
                maxProfit = prices[i] - minTillNow;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {3,2,6,5,0,3};
        System.out.println(maxProfit(a));
    }
}
