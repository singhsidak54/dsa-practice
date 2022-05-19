package ds2;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int count = 1, pEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= pEnd) {
                count++;
                pEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}