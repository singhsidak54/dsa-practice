package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePreorderTraversal {
    public static void preOrderTraversalHelper(TreeNode node, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        preOrderTraversalHelper(node.left, list);
        preOrderTraversalHelper(node.right, list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalHelper(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = preorderTraversal(root);
        System.out.println(res.toString());
    }
}
