package daily.oct22;

public class Day9TwoSumIVInputIsABST {
    public boolean findNum(TreeNode node, int num, TreeNode prevNode) {
        if(node == null) return false;

        if(node.val == num && node != prevNode) return true;

        if(node.val < num) {
            return findNum(node.right, num, prevNode);
        } else {
            return findNum(node.left, num, prevNode);
        }
    }

    public boolean findTargetHelper(TreeNode node, int k, TreeNode root) {
        if(node == null) return false;
        int reqN = k - node.val;

        if(findNum(root, reqN, node)) {
            return true;
        }

        return findTargetHelper(node.left, k, root) || findTargetHelper(node.right, k, root);
    }

    public boolean findTarget(TreeNode root, int k) {
        return findTargetHelper(root, k, root);
    }
}
