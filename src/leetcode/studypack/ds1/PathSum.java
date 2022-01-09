package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/path-sum/
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        int newVal = targetSum - root.val;
        if(newVal == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, newVal) || hasPathSum(root.right, newVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(hasPathSum(root, 1));
    }
}
