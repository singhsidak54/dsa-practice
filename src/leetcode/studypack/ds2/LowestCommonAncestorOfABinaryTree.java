package ds2;

public class LowestCommonAncestorOfABinaryTree {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.lowestCommonAncestorHelper(root, p, q);
        return this.ans;

    }

    public boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        int left = lowestCommonAncestorHelper(root.left, p, q) ? 1 : 0;

        int right = lowestCommonAncestorHelper(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if(mid + left + right >= 2) {
            this.ans = root;
        }

        return mid + left + right > 0;
    }
}
