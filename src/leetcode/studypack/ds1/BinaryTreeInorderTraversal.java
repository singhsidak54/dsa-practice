package ds1;

import java.util.ArrayList;
import java.util.List;

// Problem Link - https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {
    public static void inOrderTraversalHelper(TreeNode node, List<Integer> list) {
        if(node == null) return;

        inOrderTraversalHelper(node.left, list);
        list.add(node.val);
        inOrderTraversalHelper(node.right, list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = inorderTraversal(root);
        System.out.println(res.toString());
    }
}
