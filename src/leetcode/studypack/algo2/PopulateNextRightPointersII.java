package algo2;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNextRightPointersII {
    public static Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node temp;
            for(int i=0; i<size-1; i++) {
                temp = q.poll();
                temp.next = q.peek();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            temp = q.poll();
            temp.next = null;
            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
        }

        return root;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.right = new Node(7);
        head = connect(head);

        //System.out.println(head);
    }
}
