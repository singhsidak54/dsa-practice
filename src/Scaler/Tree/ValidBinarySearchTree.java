package Scaler.Tree;

public class ValidBinarySearchTree {

    public boolean helper(TreeNode node, int min, int max) {
        if(node == null) return true;
        if(node.val < min || node.val > max) return false;
        return helper(node.left, min, node.val - 1) && helper(node.right, node.val + 1, max);
    }
    public int isValidBST(TreeNode A) {
        return helper(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }
}
