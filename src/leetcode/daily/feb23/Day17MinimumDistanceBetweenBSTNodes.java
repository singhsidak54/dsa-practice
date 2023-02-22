package daily.feb23;

public class Day17MinimumDistanceBetweenBSTNodes {
    int pre, min;

    public void dfs(TreeNode node) {
        if(node == null) return;

        dfs(node.left);
        min = Math.min(min, node.val - pre);
        pre = node.val;
        dfs(node.right);
    }
    public int minDiffInBST(TreeNode root) {
        pre = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }
}
