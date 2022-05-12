package leetcode.studypack.algo1;

import java.util.LinkedList;
import java.util.Queue;

// Problem Link - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// Definition for a Node.
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


public class PopulatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node temp;
            for(int i=0; i<size-1; i++) {
                temp = q.poll();
                temp.next = q.peek();
                if(temp.left != null) {
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
            temp = q.poll();
            temp.next = null;
            if(temp.left != null) {
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return root;
    }
}
