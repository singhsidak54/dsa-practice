package lc75l2;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }


        int mergeStart = (i == intervals.length) ? newInterval[0] : Math.min(intervals[i][0], newInterval[0]);
        int mergeEnd = newInterval[1];
        while (i<intervals.length && intervals[i][0] <= mergeEnd) {
            mergeEnd = Math.max(mergeEnd, intervals[i][1]);
            i++;
        }
        res.add(new int[] {mergeStart, mergeEnd});

        int totalSize = res.size() + intervals.length - i;
        int[][] ans = new int[totalSize][2];
        for(int j=0; j<res.size(); j++) {
            ans[j] = res.get(j);
        }

        int k = res.size();
        while (i < intervals.length) {
            ans[k++] = intervals[i++];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(insert(new int[][] {}, new int[] {2,5}));
    }
}
