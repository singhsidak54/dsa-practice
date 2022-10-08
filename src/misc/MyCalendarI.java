package misc;

import java.util.TreeMap;

public class MyCalendarI {
    TreeMap<Integer, Integer> map;
    public MyCalendarI() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if(low != null && map.get(low) > start) {
            return false;
        }
        map.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendarI test = new MyCalendarI();

        test.book(10, 20);
        System.out.println(test.book(2,10));
    }
}
