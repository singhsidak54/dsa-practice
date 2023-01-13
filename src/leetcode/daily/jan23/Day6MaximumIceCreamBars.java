package daily.jan23;

import java.util.Arrays;

public class Day6MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for(int i=0; i<costs.length; i++) {
            if(costs[i] > coins) {
                return i;
            } else {
                coins -= costs[i];
            }
        }

        return costs.length;
    }

    public int maxIceCreamOptimised(int[] costs, int coins) {
        int max = costs[0];
        for(int cost : costs) {
            max = Math.max(max, cost);
        }

        int[] freqArray = new int[max + 1];
        for(int cost : costs) {
            freqArray[cost]++;
        }

        int iceCreams = 0;
        for(int i=0; i<freqArray.length; i++) {
            if(freqArray[i] == 0) continue;
            
            if(i > coins) return iceCreams;

            int currentBuy = Math.min(freqArray[i], coins/i);
            iceCreams += currentBuy;
            coins -= (i * currentBuy);
        }

        return iceCreams;
    }
}
