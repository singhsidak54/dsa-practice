package patterns.intuit;


import java.util.LinkedList;
import java.util.Queue;

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
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size-1; i++) {
                Node curr = queue.poll();
                curr.next = queue.peek();
                if(curr.left != null) {
                    queue.add(curr.left);
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }

            Node curr = queue.poll();
            if(curr.left != null) {
                queue.add(curr.left);
            }

            if(curr.right != null) {
                queue.add(curr.right);
            }
        }

        return root;
    }

    public void helper(Node node) {
        if(node == null) return;
        Node curr = node;
        while (curr != null) {
            if(curr.left != null && curr.right != null) {
                curr.left.next = curr.right;
            }

            if(curr.right != null && curr.next != null) {
                curr.right.next = curr.next.left;
            }

            curr = curr.next;
        }

        helper(node.left);
    }

    public Node connectRecursive(Node root) {
        helper(root);
        return root;
    }
}
