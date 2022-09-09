package dp1;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length-1; i++) {

            while (i<prices.length-1 && prices[i] >= prices[i+1])
                i++;

            //buying price
            maxProfit -= prices[i];

            while (i<prices.length-1 && prices[i] < prices[i+1])
                i++;

            //selling price
            maxProfit += prices[i];
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
