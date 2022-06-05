package ds2;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.addToStack(root);
    }

    private void addToStack(TreeNode node) {
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode temp = this.stack.pop();
        if(temp.right != null) {
            this.addToStack(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}