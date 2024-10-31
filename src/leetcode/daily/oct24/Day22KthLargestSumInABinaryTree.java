package daily.oct24;

import java.util.*;

public class Day22KthLargestSumInABinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Map<Integer, Long> levelSums;

    public void helper(TreeNode node, int level) {
        if(node == null) return;

        if(!levelSums.containsKey(level)) {
            levelSums.put(level, 0L);
        }

        levelSums.put(level, levelSums.get(level) + node.val);
        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        levelSums = new HashMap<>();
        helper(root, 0);
        List<Long> sums = new ArrayList<>(levelSums.values());
        sums.sort(Collections.reverseOrder());
        if(sums.size() < k) return -1;
        return sums.get(k - 1);
    }
}
