package leetcode.studypack.ds1;

import java.util.ArrayList;
import java.util.List;

// Problem Link - https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
    public static void postOrderTraversalHelper(TreeNode node, List<Integer> list) {
        if(node == null) return;

        postOrderTraversalHelper(node.left, list);
        postOrderTraversalHelper(node.right, list);
        list.add(node.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalHelper(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = postorderTraversal(root);
        System.out.println(res.toString());
    }
}
