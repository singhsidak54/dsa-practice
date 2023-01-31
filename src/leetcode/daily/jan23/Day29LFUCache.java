package daily.jan23;

import java.util.HashMap;

public class Day29LFUCache {
    class Node {
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        public Node () {

        }
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DLList {
        Node head;
        Node tail;

        int size;

        public DLList() {
            this.head = new Node();
            this.tail = new Node();
            this.size = 0;
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.size--;
        }

        public void insert(Node node) {
            node.next = this.head.next;
            node.next.prev = node;
            this.head.next = node;
            node.prev = this.head;
            this.size++;
        }

        public Node removeLast() {
            Node last = this.tail.prev;
            this.remove(last);
            return last;
        }
    }

    HashMap<Integer, DLList> frequencyHead;
    HashMap<Integer, Node> cache;

    int maxCapacity;
    int currCapacity;

    int minFreq;
    public Day29LFUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currCapacity = 0;
        minFreq = 0;
        this.cache = new HashMap<>();
        this.frequencyHead = new HashMap<>();
    }

    private void update(Node node) {
        DLList freqList = this.frequencyHead.get(node.freq);
        freqList.remove(node);
        if(freqList.size == 0 && this.minFreq == node.freq) {
            this.minFreq++;
        }
        node.freq++;

        DLList newList = this.frequencyHead.getOrDefault(node.freq, new DLList());
        newList.insert(node);
        this.frequencyHead.put(node.freq, newList);
    }

    public int get(int key) {
        if(!this.cache.containsKey(key)) {
            return -1;
        }

        Node node = this.cache.get(key);
        this.update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(this.maxCapacity == 0) return;

        if(this.cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            this.update(node);
            return;
        }

        if(this.currCapacity == this.maxCapacity) {
            DLList minFreqList = this.frequencyHead.get(minFreq);
            Node lFUNode = minFreqList.removeLast();
            this.cache.remove(lFUNode.key);
            this.currCapacity--;
        }

        this.currCapacity++;
        Node node = new Node(key, value);
        this.minFreq = 1;
        DLList newList = this.frequencyHead.getOrDefault(node.freq, new DLList());
        newList.insert(node);
        this.frequencyHead.put(node.freq, newList);
        this.cache.put(key, node);
    }

    public static void main(String[] args) {
        Day29LFUCache obj = new Day29LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(4,4);
    }
}
