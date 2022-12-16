package daily.dec22;

public class Day9MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiffHelper(TreeNode node, int max, int min) {
        if(node == null) return max - min;

        int newMax = Math.max(node.val, max);
        int newMin = Math.min(node.val, min);

        int leftMax = maxAncestorDiffHelper(node.left, newMax, newMin);
        int rightMax = maxAncestorDiffHelper(node.right, newMax, newMin);

        return Math.max(leftMax, rightMax);
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffHelper(root, root.val, root.val);
    }
}
