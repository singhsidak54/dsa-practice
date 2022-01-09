package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode temp = invertTree(root.right);
            root.right = invertTree(root.left);
            root.left = temp;
        }
        return root;
    }
}
