package daily.oct22;

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

public class Day4PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        int newSum = targetSum - root.val;
        if(newSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}
