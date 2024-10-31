package daily.oct24;

import java.util.*;

public class Day12DivideIntervalsIntoMinimumNumberOfGroups {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> endings = new PriorityQueue<>();
        int max = 0;
        for(int[] interval : intervals) {
            while (!endings.isEmpty() && endings.peek() < interval[0]) {
                endings.poll();
            }

            endings.add(interval[1]);
            max = Math.max(max, endings.size());
        }

        return max;
    }

    public int minGroupsOptimised(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        for(int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});
            events.add(new int[] {interval[1] + 1, -1});
        }

        Collections.sort(events, (a, b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int max = 0, current = 0;
        for(int[] event : events) {
            current += event[1];
            max = Math.max(max, current);
        }

        return max;
    }
    public static void main(String[] args) {
        int[][] intervals = {{228525,336985},{807945,946787},{693292,944029},{751962,821744}};
        Day12DivideIntervalsIntoMinimumNumberOfGroups obj = new Day12DivideIntervalsIntoMinimumNumberOfGroups();
        System.out.println(obj.minGroupsOptimised(intervals));
    }
}
