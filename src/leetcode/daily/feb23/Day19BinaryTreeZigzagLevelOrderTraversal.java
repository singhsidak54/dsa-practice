package daily.feb23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day19BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        boolean isEven = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if(isEven) {
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }

                if(curr.left != null) {
                    queue.add(curr.left);
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(level);
            isEven = !isEven;
        }

        return result;
    }
}
