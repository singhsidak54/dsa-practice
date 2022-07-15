package lc75l1;

public class ValidateBinarySearchTree {
    public static boolean isValidBST2Helper(TreeNode node, long minValue, long maxValue) {
        if(node == null) return true;

        if(node.val >= maxValue || node.val <= minValue) return false;

        return isValidBST2Helper(node.left, minValue, node.val) && isValidBST2Helper(node.right, node.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST2Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
