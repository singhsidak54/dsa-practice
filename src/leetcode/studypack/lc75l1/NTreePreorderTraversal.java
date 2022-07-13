package lc75l1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(curr.val);

            if(curr.children == null) {
                continue;
            }

            for(int i=curr.children.size() - 1; i>=0; i--) {
                stack.add(curr.children.get(i));
            }
        }

        return res;
    }
}
