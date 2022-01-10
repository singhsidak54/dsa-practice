package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
