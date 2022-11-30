package daily.nov22;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day12FindMedianFromDataStream {
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;
    boolean isEven;

    public Day12FindMedianFromDataStream() {
        firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        secondHalf = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if(isEven) {
            secondHalf.add(num);
            firstHalf.add(secondHalf.poll());
        } else {
            firstHalf.add(num);
            secondHalf.add(firstHalf.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if(isEven) {
            return (firstHalf.peek() + secondHalf.peek())/2.0;
        } else {
            return firstHalf.peek();
        }
    }
}
