package lc75l2;


public class MinStack {

    class Node {
        int element;
        int min;
        Node next;
        public Node(int element, int min, Node next) {
            this.element = element;
            this.min = min;
            this.next = next;
        }
    }

    Node head;
    public MinStack() {
    }

    public void push(int val) {
        if(head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.element;
    }

    public int getMin() {
        return head.min;
    }
}
