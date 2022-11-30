package daily.nov22;

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
public class Day15CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int l = 0, r = 0;
        TreeNode curr = root;
        while (curr != null) {
            curr = curr.left;
            l++;
        }

        curr = root;
        while (curr != null) {
            curr = curr.right;
            r++;
        }

        if(l == r) {
            return (int) Math.pow(2, l) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
