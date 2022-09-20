package lc75l2;

public class BalancedBinaryTree {
    public int height(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;

        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public int height2(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = height2(node.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height2(node.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(rightHeight - leftHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return height2(root) != -1;
    }
}
