package daily.sep24;

import java.util.Map;
import java.util.TreeMap;

public class Day26MyCalendarI {
    TreeMap<Integer, Integer> starts;
    public Day26MyCalendarI() {
        this.starts = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> before = this.starts.lowerEntry(end);
        if (before != null && before.getValue() > start) return false;
        this.starts.put(start, end);
        return true;
    }
}
