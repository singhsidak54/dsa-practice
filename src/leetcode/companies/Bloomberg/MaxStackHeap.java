package companies.Bloomberg;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaxStackHeap {
    class Node {
        int val;
        int index;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, int index, Node prev, Node next) {
            this.val = val;
            this.index = index;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    int index;
    PriorityQueue<Node> pq;

    HashSet<Integer> removed;
    public MaxStackHeap() {
        head = new Node(-1);
        tail = new Node(-1);
        index = 0;

        head.next = tail;
        tail.prev = head;

        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val == o2.val) {
                    return Integer.compare(o2.index, o1.index);
                }
                return Integer.compare(o2.val, o1.val);
            }
        });

        removed = new HashSet<>();
    }

    public void push(int x) {
        Node newNode = new Node(x, index++, tail.prev, tail);

        tail.prev.next = newNode;
        tail.prev = newNode;
        pq.add(newNode);
    }

    public int pop() {
        Node last = tail.prev;

        last.prev.next = tail;
        tail.prev = last.prev;

        removed.add(last.index);
        return last.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        while (removed.contains(pq.peek().index)) {
            removed.remove(pq.poll().index);
        }

        return pq.peek().val;
    }

    public int popMax() {
        while (removed.contains(pq.peek().index)) {
            removed.remove(pq.poll().index);
        }

        Node latestMaxNode = pq.peek();
        latestMaxNode.prev.next = latestMaxNode.next;
        latestMaxNode.next.prev = latestMaxNode.prev;

        removed.add(latestMaxNode.index);
        return latestMaxNode.val;
    }

    public static void main(String[] args) {
        MaxStackHeap obj = new MaxStackHeap();
        obj.push(-95);
        obj.push(1);
        System.out.println(obj.popMax());
        obj.push(-44);
        obj.push(-16);
        System.out.println(obj.top());
        obj.push(29);
        obj.push(65);
        obj.push(-18);
        System.out.println(obj.pop());
        System.out.println(obj.popMax());
        System.out.println(obj.pop());
        obj.push(78);
    }
}
