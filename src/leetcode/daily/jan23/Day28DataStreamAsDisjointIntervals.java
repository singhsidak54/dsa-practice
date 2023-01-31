package daily.jan23;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Day28DataStreamAsDisjointIntervals {

    TreeMap<Integer, Integer> treeMap;
    public Day28DataStreamAsDisjointIntervals() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int value) {
        int end = value;
        Integer ceilKey = treeMap.ceilingKey(value);
        if(ceilKey != null && value == ceilKey - 1) {
            end = treeMap.get(ceilKey);
            treeMap.remove(ceilKey);
        }

        Integer floorKey = treeMap.floorKey(value);
        if(floorKey != null && value - 1 <= treeMap.get(floorKey)) {
            treeMap.put(floorKey, Math.max(end, treeMap.get(floorKey)));
        } else {
            treeMap.put(value, end);
        }
    }

    public int[][] getIntervals() {
        int[][] intervals = new int[treeMap.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            intervals[i][0] = entry.getKey();
            intervals[i][1] = entry.getValue();
            i++;
        }

        return intervals;
    }
}
