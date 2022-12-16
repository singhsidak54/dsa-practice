package daily.dec22;

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

public class Day7RangeSumOfBST {
    int sum = 0;

    public void rangeSumBSTHelper(TreeNode node, int low, int high) {
        if(node == null) return;

        if(node.val >= low && node.val <= high) {
            this.sum += node.val;
            rangeSumBSTHelper(node.left, low, high);
            rangeSumBSTHelper(node.right, low, high);
        } else if (node.val >= low) {
            rangeSumBSTHelper(node.left, low, high);
        } else {
            rangeSumBSTHelper(node.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumBSTHelper(root, low, high);
        return sum;
    }
}
