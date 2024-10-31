package daily.sep24;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day27MyCalendarII {
    TreeMap<Integer, Integer> bookings;
    public Day27MyCalendarII() {
        this.bookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end , 0) - 1);
        int overlappingCount = 0;

        for (int value : bookings.values()) {
            overlappingCount += value;
            if (overlappingCount > 2) {
                bookings.put(start, bookings.get(start) - 1);
                bookings.put(end, bookings.get(end) + 1);

                if (bookings.get(start) == 0) bookings.remove(start);
                if (bookings.get(end) == 0) bookings.remove(end);
                return false;
            }
        }
        return true;
    }
}

/* Optimised solution */
class MyCalendarTwo {
    List<int[]> overlaps, bookings;
    public MyCalendarTwo() {
        overlaps = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public boolean doesOverlap(int start1, int start2, int end1, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    public int[] overlapRange(int start1, int start2, int end1, int end2) {
        return new int[] {Math.max(start1, start2), Math.min(end1, end2)};
    }

    public boolean book(int start, int end) {
        for(int[] overlap : overlaps) {
            if (doesOverlap(overlap[0], start, overlap[1], end)) return false;
        }

        for(int[] booking : bookings) {
            if (doesOverlap(booking[0], start, booking[1], end)) {
                overlaps.add(overlapRange(booking[0], start, booking[1], end));
            }
        }

        bookings.add(new int[] {start, end});
        return true;
    }
}
