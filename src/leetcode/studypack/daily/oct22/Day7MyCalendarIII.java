package daily.oct22;

import java.util.TreeMap;

public class Day7MyCalendarIII {
    int currAns;
    TreeMap<Integer, Integer> calendar;
    public Day7MyCalendarIII() {
        this.currAns = 0;
        this.calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        if(calendar.get(start) == 0) {
            calendar.remove(start);
        }

        if(calendar.get(end) == 0) {
            calendar.remove(end);
        }

        int overlapCount = 0;
        for(int key : calendar.keySet()) {
            if(key >= end) {
                break;
            }
            overlapCount += calendar.get(key);
            currAns = Math.max(currAns, overlapCount);
        }

        return currAns;
    }

    public static void main(String[] args) {
        Day7MyCalendarIII test = new Day7MyCalendarIII();

        System.out.println(test.book(26,35));
        System.out.println(test.book(26,32));
        System.out.println(test.book(25,32));
        System.out.println(test.book(18,26));
        System.out.println(test.book(40,45));
        System.out.println(test.book(19, 26));
        System.out.println(test.book(48,50));
    }
}
