package daily.apr23;

import java.util.HashMap;

public class Day19LongestZigZagPathInABinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max;

    public void backtrack(TreeNode node, int len, boolean isLeft) {
        if(node == null) return;

        max = Math.max(max, len);

        if(isLeft) {
            backtrack(node.left, len + 1, false);
            backtrack(node.right, 1, true);
        } else {
            backtrack(node.right, len + 1, true);
            backtrack(node.left, 1, false);
        }
    }

    public int longestZigZag(TreeNode root) {
        max = 0;
        backtrack(root, 0, false);
        backtrack(root, 0, true);
        return max;
    }
}
