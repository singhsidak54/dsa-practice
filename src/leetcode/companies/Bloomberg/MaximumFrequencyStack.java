package companies.Bloomberg;

import java.util.*;

public class MaximumFrequencyStack {

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    class DLList {
        Node head;
        Node tail;

        int size;
        public DLList() {
            this.size = 0;
            this.head = new Node(-1);
            this.tail = new Node(-1);

            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void add(int val) {
            Node node = new Node(val);
            // next and prev pointers of node
            node.next = this.tail;
            node.prev = this.tail.prev;

            // next pointer of second last node
            this.tail.prev.next = node;
            // prev pointer of tail
            this.tail.prev = node;
            this.size++;
        }

        public Node remove() {
            Node toRemove = this.tail.prev;

            // prev pointer of tail
            this.tail.prev = toRemove.prev;

            // next pointer of last node to tail
            toRemove.prev.next = this.tail;

            this.size--;
            return toRemove;
        }
    }

    HashMap<Integer, Integer> frequencyCount;
    TreeMap<Integer, DLList> frequencyMap;
    public MaximumFrequencyStack() {
        frequencyCount = new HashMap<>();
        frequencyMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void push(int val) {
        int newFreq = frequencyCount.getOrDefault(val, 0) + 1;
        frequencyCount.put(val, newFreq);

        DLList freqList = frequencyMap.getOrDefault(newFreq, new DLList());
        freqList.add(val);
        frequencyMap.put(newFreq, freqList);
    }

    public int pop() {
        Map.Entry<Integer, DLList> firstEntry = frequencyMap.firstEntry();
        Node toRemove = firstEntry.getValue().remove();

        if(firstEntry.getValue().size == 0) {
            frequencyMap.remove(firstEntry.getKey());
        } else {
            frequencyMap.put(firstEntry.getKey(), firstEntry.getValue());
        }

        int newFreq = frequencyCount.get(toRemove.val) - 1;
        if(newFreq == 0) {
            frequencyCount.remove(toRemove.val);
        } else {
            frequencyCount.put(toRemove.val, newFreq);
        }

        return toRemove.val;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
