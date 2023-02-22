package daily.feb23;

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

public class Day16MaximumDepthOfBinaryTree {
    int max;

    public void dfs(TreeNode node, int depth) {
        max = Math.max(max, depth);
        if(node == null) {
            return;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 0);
        return max;
    }
}
