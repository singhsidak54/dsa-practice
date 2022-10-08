package misc;

import java.util.TreeMap;

public class MyCalendarII {
    TreeMap<Integer, Integer> calendar;
    public MyCalendarII() {
        this.calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int overlapCount = 0;
        for(int n : calendar.values()) {
            overlapCount += n;
            if(overlapCount > 2) {
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                if(calendar.get(start) == 0) {
                    calendar.remove(start);
                }

                if(calendar.get(end) == 0) {
                    calendar.remove(end);
                }
                return false;
            }
        }

        return true;
    }
}
