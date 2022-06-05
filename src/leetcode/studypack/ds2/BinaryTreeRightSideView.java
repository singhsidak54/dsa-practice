package ds2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                if(i == size - 1) result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, 1, result);
        return result;
    }

    public void rightSideViewHelper(TreeNode root, int level, List<Integer> result) {
        if(root == null) return;

        if(result.size() < level) result.add(root.val);

        rightSideViewHelper(root.right, level + 1, result);
        rightSideViewHelper(root.left, level + 1, result);
    }
}
