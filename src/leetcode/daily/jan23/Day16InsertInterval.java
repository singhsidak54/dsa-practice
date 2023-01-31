package daily.jan23;

import java.util.ArrayList;
import java.util.List;

public class Day16InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean merged = false;
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            if(intervals[i][0] > newInterval[1]) {
                mergedIntervals.add(newInterval);
            } else if(intervals[i][1] < newInterval[0]) {
                mergedIntervals.add(intervals[i]);
            } else {
                merged = true;
                int j = i;
                int start = Math.min(intervals[i][0], newInterval[0]), end = Math.max(intervals[i][1], newInterval[1]);
                while (j < intervals.length) {
                    if(intervals[j][0] <= end) {
                        end = Math.max(end, intervals[j][1]);
                        j++;
                    } else {
                        break;
                    }
                }

                mergedIntervals.add(new int[] {start, end});
                i = j;
                break;
            }
            i++;
        }

        if(!merged) {
            mergedIntervals.add(newInterval);
        }

        int[][] ans = new int[mergedIntervals.size() + intervals.length - i][2];
        int k = 0;
        for(; k<mergedIntervals.size(); k++) {
            ans[k] = mergedIntervals.get(k);
        }

        for(; i < intervals.length; i++, k++) {
            ans[k] = intervals[i];
        }

        return ans;
    }
}
