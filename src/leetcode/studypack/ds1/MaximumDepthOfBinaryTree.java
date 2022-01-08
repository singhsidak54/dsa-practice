package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if(leftDepth > rightDepth)
            return 1 + leftDepth;
        else
            return 1 + rightDepth;
    }
}
