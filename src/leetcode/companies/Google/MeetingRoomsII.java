package companies.Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    /* Priority Queue and Number Line based solution */
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int [] interval : intervals) {
            pq.add(new int[] {interval[0], 1});
            pq.add(new int[] {interval[1], -1});
        }

        int maxRooms = 0, currentRooms = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            currentRooms += curr[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }

    /* Sorting and PQ based solution */
    public int minMeetingRoomsSolution(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

    /* Sort the start time and end time separately */
    public int minMeetingRoomsSortSeparateSolution(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, endPtr = 0;

        for(int i=0; i<n; i++) {
            if(start[i] >= end[endPtr]) {
                rooms--;
                endPtr++;
            }

            rooms++;
        }

        return rooms;
    }
}
