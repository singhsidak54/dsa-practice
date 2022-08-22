package bs2;

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

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int l = 0, r = 0;

        TreeNode left = root, right = root;
        while (left != null) {
            left = left.left;
            l++;
        }

        while (right != null) {
            right = right.right;
            r++;
        }

        if(l == r) {
            return (int) (Math.pow(2, l) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
