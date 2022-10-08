package daily.oct22;

public class Day5AddOneRowToTree {
    public void addOneRowHelper(TreeNode node, int val, int depth) {
        if(node == null) {
            return;
        }

        if(depth == 1) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            newLeft.left = node.left;
            newRight.right = node.right;

            node.left = newLeft;
            node.right = newRight;
            return;
        }

        addOneRowHelper(node.left, val, depth - 1);
        addOneRowHelper(node.right, val, depth - 1);
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        addOneRowHelper(root, val, depth - 1);
        return root;
    }
}
