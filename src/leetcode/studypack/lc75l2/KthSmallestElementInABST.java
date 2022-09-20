package lc75l2;

import java.util.Stack;

public class KthSmallestElementInABST {
    int position = 0;
    public TreeNode kthSmallestHelper(TreeNode root, int k) {
        if(root == null) return null;

        TreeNode leftAns = kthSmallestHelper(root.left, k);
        if(leftAns != null) return leftAns;

        position++;
        if(k == position) return root;

        return kthSmallestHelper(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if(k == 1) return root.val;
            root = root.right;
            k--;
        }
    }
}
