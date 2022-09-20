package lc75l2;

public class DiameterOfBinaryTree {
    int maxTillNow = 0;
    public int diameterHelper(TreeNode node) {
        if(node == null) return 0;

        int leftMax = diameterHelper(node.left);
        int rightMax = diameterHelper(node.right);

        maxTillNow = Math.max(maxTillNow, leftMax + rightMax);

        return Math.max(leftMax, rightMax);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return maxTillNow;
    }
}
