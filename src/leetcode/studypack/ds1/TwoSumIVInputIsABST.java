package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSumIVInputIsABST {
    public static boolean contains(TreeNode node, int n, TreeNode curr) {
        if(node == null)
            return false;

        if(node.val == n && node != curr) return true;
        if(node.val > n)
            return contains(node.left, n, curr);
        else
            return contains(node.right, n, curr);
    }

    public static boolean findTargetHelper(TreeNode node, int k, TreeNode root) {
        if(node == null)
            return false;

        int numToFind = k - node.val;

        if(contains(root, numToFind, node))
            return true;
        else
            return findTargetHelper(node.left, k, root) || findTargetHelper(node.right, k, root);

    }

    public static boolean findTarget(TreeNode root, int k) {
        return findTargetHelper(root, k, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(7);
        System.out.println(findTarget(root, 4));
    }
}
