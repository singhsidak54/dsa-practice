package daily.mar23;

import java.util.HashMap;

public class Day16ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
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

    int postIdx;
    HashMap<Integer, Integer> inorderIdx;
    public TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if(left > right) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postIdx]);
        postIdx--;

        node.right = helper(inorder, postorder, inorderIdx.get(node.val) + 1, right);
        node.left = helper(inorder, postorder, left, inorderIdx.get(node.val) - 1);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIdx = new HashMap<>();
        postIdx = postorder.length - 1;

        for(int i=0; i<inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }
}
