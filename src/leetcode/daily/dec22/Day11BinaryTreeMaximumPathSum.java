package daily.dec22;

public class Day11BinaryTreeMaximumPathSum {
    int maxSum = 0;
    public int maxPathSumHelper(TreeNode node) {
        if(node == null) return 0;

        int leftSum = maxPathSumHelper(node.left);
        int rightSum = maxPathSumHelper(node.right);

        int currentMaxSum = Math.max(leftSum, 0) + Math.max(rightSum, 0) + node.val;
        maxSum = Math.max(maxSum, currentMaxSum);
        return node.val + Math.max(0, Math.max(leftSum, rightSum));
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        maxPathSumHelper(root);
        return maxSum;
    }
}
