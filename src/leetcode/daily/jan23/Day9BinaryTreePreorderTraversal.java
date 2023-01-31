package daily.jan23;

import java.util.ArrayList;
import java.util.List;
import daily.jan23.Day10SameTree.TreeNode;
public class Day9BinaryTreePreorderTraversal {
    public static void preOrderTraversalHelper(TreeNode node, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        preOrderTraversalHelper(node.left, list);
        preOrderTraversalHelper(node.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalHelper(root, list);
        return list;
    }
}
