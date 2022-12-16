package companies.Google;

import java.util.Map;
import java.util.TreeMap;

public class AmountOfNewAreaPaintedEachDay {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = paint.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int start = paint[i][0];
            int end = paint[i][1];
            int toPaint = end - start;

            Map.Entry<Integer, Integer> floor = treeMap.floorEntry(start);
            if(floor != null) {
                if(floor.getValue() >= end) {
                    continue;
                }

                if(floor.getValue() >= start) {
                    toPaint -= floor.getValue() - start;
                    start = floor.getKey();
                    treeMap.remove(floor.getKey());
                }
            }

            Map.Entry<Integer, Integer> ceiling = treeMap.ceilingEntry(start);
            while (ceiling != null && ceiling.getKey() <= end) {
                toPaint -= Math.min(end, ceiling.getValue()) - ceiling.getKey();
                end = Math.max(end, ceiling.getValue());
                treeMap.remove(ceiling.getKey());
                ceiling = treeMap.ceilingEntry(start);
            }

            ans[i] = toPaint;
            treeMap.put(start, end);
        }

        return ans;
    }

    public int[] amountPaintedJumpLine(int[][] paint) {
        int[] numberLine = new int[100001];
        int[] ans = new int[paint.length];

        for(int i=0; i<paint.length; i++) {
            int start = paint[i][0], end = paint[i][1], painted = 0;
            while (start < end) {
                int jump = numberLine[start];
                if(numberLine[start] == 0) {
                    painted++;
                }
                numberLine[start] = Math.max(end, jump);
                start = Math.max(jump, start + 1);
            }

            ans[i] = painted;
        }

        return ans;
    }
}
