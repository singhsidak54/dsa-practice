package ds2;

class Node {
    int val;
    Node next;
    int min;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
public class MinStack {
    private Node head;
    public MinStack() {
        this.head = null;
    }

    public void push(int val) {
        if(this.head == null) {
            this.head = new Node(val, val, null);
        } else {
            this.head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
