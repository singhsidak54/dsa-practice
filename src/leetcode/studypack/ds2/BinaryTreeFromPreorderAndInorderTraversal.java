package ds2;

import java.util.HashMap;

public class BinaryTreeFromPreorderAndInorderTraversal {
    int preOrderIndex = 0;
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder,0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int left, int right) {
        if(left > right) return null;

        TreeNode node = new TreeNode(preOrder[preOrderIndex]);
        preOrderIndex++;
        node.left = buildTreeHelper(preOrder, left,inorderIndexMap.get(node.val) - 1);
        node.right = buildTreeHelper(preOrder, inorderIndexMap.get(node.val) + 1, right);
        return node;
    }
}
