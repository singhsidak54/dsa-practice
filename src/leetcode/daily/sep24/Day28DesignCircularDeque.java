package daily.sep24;

public class Day28DesignCircularDeque {
    class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    int size;
    Node head;
    Node tail;
    int capacity;
    public Day28DesignCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.head = new Node(-1);
        this.tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (size == capacity) return false;
        Node prevStart = head.next;
        Node node = new Node(value, head, prevStart);
        prevStart.prev = node;
        head.next = node;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) return false;
        Node prevEnd = tail.prev;
        Node node = new Node(value, tail.prev, tail);
        prevEnd.next = node;
        tail.prev = node;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        Node toDelete = head.next;
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        Node toDelete = tail.prev;
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        size--;
        return true;
    }

    public int getFront() {
        return size == 0 ? -1 : head.next.value;
    }

    public int getRear() {
        return size == 0 ? -1 : tail.prev.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
