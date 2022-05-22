package algo2;

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

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot != null)
            return false;
        else if (root != null && subRoot == null) {
            return false;
        } else if(root.val == subRoot.val) {
            if(checkTreeMatch(root.left, subRoot.left) && checkTreeMatch(root.right, subRoot.right))
                return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean checkTreeMatch(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        } else if(node1 != null && node2 != null && node1.val == node2.val) {
            return checkTreeMatch(node1.left, node2.left) && checkTreeMatch(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
