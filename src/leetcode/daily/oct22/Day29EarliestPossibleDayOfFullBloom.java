package daily.oct22;

import java.util.Arrays;
import java.util.Comparator;

public class Day29EarliestPossibleDayOfFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] data = new int[plantTime.length][2];
        for(int i=0; i<plantTime.length; i++) {
            data[i][0] = growTime[i];
            data[i][1] = plantTime[i];
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int plantSum = 0, res = 0;
        for(int[] plant : data) {
            plantSum += plant[1];
            res = Math.max(res, plantSum + plant[0]);
        }

        return res;
    }
}
