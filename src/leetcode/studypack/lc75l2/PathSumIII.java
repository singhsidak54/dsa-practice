package lc75l2;

import java.util.HashMap;

public class PathSumIII {
    static int count = 0;

    public static int pathSumHelper(TreeNode node, long currSum) {
        if(node == null) {
            return 0;
        }

        return (node.val == currSum ? 1 : 0) + pathSumHelper(node.left, currSum - node.val) + pathSumHelper(node.right, currSum - node.val);
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        return pathSumHelper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumPreSumHelper(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> preSum) {
        if(node == null) return 0;

        long newSum = currSum + node.val;

        int res = preSum.getOrDefault(newSum - targetSum, 0);
        preSum.put(newSum, preSum.getOrDefault(newSum, 0) + 1);

        res += pathSumPreSumHelper(node.left, newSum, targetSum, preSum) + pathSumPreSumHelper(node.right, newSum, targetSum, preSum);
        preSum.put(newSum, preSum.getOrDefault(newSum, 0) - 1);

        return res;
    }

    public int pathSumPreSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSum = new HashMap<>();
        preSum.put(0l, 1);
        return pathSumPreSumHelper(root, 0, targetSum, preSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        root.left.left = new TreeNode(3);

        System.out.println(pathSum(root, 3));
    }
}
