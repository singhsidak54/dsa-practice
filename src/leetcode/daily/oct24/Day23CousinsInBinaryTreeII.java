package daily.oct24;

import java.util.HashMap;
import java.util.Map;

public class Day23CousinsInBinaryTreeII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    Map<Integer, Integer> levelSums;

    public void build(TreeNode node, int level) {
        if(node == null) return;

        if(!levelSums.containsKey(level)) {
            levelSums.put(level, 0);
        }

        levelSums.put(level, levelSums.get(level) + node.val);
        build(node.left, level + 1);
        build(node.right, level + 1);
    }

    public void replace(TreeNode node, int totalSiblingSum, int level) {
        if(node == null) return;

        node.val = levelSums.get(level) - totalSiblingSum;

        int currentNodeChildrenSum = 0;
        if(node.left != null) currentNodeChildrenSum += node.left.val;
        if(node.right != null) currentNodeChildrenSum += node.right.val;

        replace(node.left, currentNodeChildrenSum, level + 1);
        replace(node.right, currentNodeChildrenSum, level + 1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        levelSums = new HashMap<>();
        build(root, 0);
        replace(root, root.val, 0);
        return root;
    }
}
