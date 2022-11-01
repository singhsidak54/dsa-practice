package patterns.intuit;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> smallPart;
    PriorityQueue<Integer> largePart;
    boolean even;
    public FindMedianFromDataStream() {
        smallPart = new PriorityQueue<>(Collections.reverseOrder());
        largePart = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if(even) {
            largePart.add(num);
            smallPart.add(largePart.poll());
        } else {
            smallPart.add(num);
            largePart.add(smallPart.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even) {
            return (smallPart.peek() + largePart.peek())/2.0;
        } else {
            return smallPart.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
