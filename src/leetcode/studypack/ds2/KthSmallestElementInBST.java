package ds2;

import java.util.Stack;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(k == 1) return root.val;
            root = root.right;
            k--;
        }
    }
}
