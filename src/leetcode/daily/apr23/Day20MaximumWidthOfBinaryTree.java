package daily.apr23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day20MaximumWidthOfBinaryTree {
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


    public int dfs(TreeNode node, int level, int index, List<Integer> list) {
        if(node == null) return 0;

        if(level >= list.size()) {
            list.add(index);
        }

        int curr = index + 1 - list.get(level);
        int left = dfs(node.left, level + 1, index * 2, list);
        int right = dfs(node.right, level + 1, index * 2 + 1, list);

        return Math.max(curr, Math.max(left, right));
    }
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return dfs(root, 0, 0, list);
    }
}
