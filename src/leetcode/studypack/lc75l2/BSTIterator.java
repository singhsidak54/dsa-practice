package lc75l2;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    private void fillStack(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        if(temp.right != null) {
            fillStack(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
