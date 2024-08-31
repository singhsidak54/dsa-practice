package daily.aug24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day26NaryTreePostorderTraversal {

    // Definition for a Node.
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

    public void dfs(Node node, List<Integer> res) {
        for(Node child : node.children) {
            dfs(child, res);
        }
        res.add(node.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res);
        return res;
    }

    public List<Integer> postorderIterative(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.addFirst(curr.val);

            for(Node child : curr.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
