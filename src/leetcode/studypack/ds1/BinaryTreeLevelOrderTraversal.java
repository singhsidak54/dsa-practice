package leetcode.studypack.ds1;

import java.util.*;

// Problem Link - https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(level);
        }

        return res;
    }
}
