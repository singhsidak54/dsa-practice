package companies.Google;

import java.util.ArrayList;
import java.util.List;

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

public class FindLeavesOfBinaryTree {
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void removeLeaves(TreeNode node, List<Integer> currentList) {
        if(node.left != null) {
            if(isLeaf(node.left)) {
                currentList.add(node.left.val);
                node.left = null;
            } else {
                removeLeaves(node.left, currentList);
            }
        }

        if(node.right != null) {
            if(isLeaf(node.right)) {
                currentList.add(node.right.val);
                node.right = null;
            } else {
                removeLeaves(node.right, currentList);
            }
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (!isLeaf(root)) {
            List<Integer> currentList = new ArrayList<>();
            removeLeaves(root, currentList);
            result.add(currentList);
        }

        List<Integer> finalList = new ArrayList<>();
        finalList.add(root.val);
        result.add(finalList);

        return result;
    }

    public int getHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        if(this.solution.size() == currentHeight) {
            this.solution.add(new ArrayList<>());
        }

        this.solution.get(currentHeight).add(node.val);

        return currentHeight;
    }
    List<List<Integer>> solution;
    public List<List<Integer>> findLeavesOptimised(TreeNode root) {
        this.solution = new ArrayList<>();
        getHeight(root);
        return this.solution;
    }
}
