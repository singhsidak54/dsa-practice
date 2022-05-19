package ds2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<intervals.length; i++) {
            int lastIdx = result.size() - 1;
            if(result.isEmpty() || result.get(lastIdx)[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.get(lastIdx)[1] = Math.max(result.get(lastIdx)[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
