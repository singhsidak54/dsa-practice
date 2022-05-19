package algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int[] fLInterval = firstList[i];
            int[] sLInterval = secondList[j];
            if((sLInterval[0] >= fLInterval[0] && sLInterval[0] <= fLInterval[1])
                    || (fLInterval[0] >= sLInterval[0] && fLInterval[0] <= sLInterval[1])) {
                int[] commonInterval = { Math.max(fLInterval[0], sLInterval[0]), Math.min(fLInterval[1], sLInterval[1])};

                if(commonInterval[1] >= fLInterval[1])
                    i++;

                if(commonInterval[1] >= sLInterval[1])
                    j++;

                result.add(commonInterval);
            } else if(fLInterval[0] > sLInterval[1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] intersectionList = new int[result.size()][2];
        for(int l=0; l<result.size(); l++) {
            intersectionList[l] = result.get(l);
        }
        return intersectionList;
    }

    public static int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i=0, j=0;

        while(i<firstList.length && j<secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if(low <= high)
                result.add(new int[]{low, high});

            if(firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
