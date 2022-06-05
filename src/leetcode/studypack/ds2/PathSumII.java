package ds2;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    public static void pathSum(TreeNode node, int target, List<Integer> currList, List<List<Integer>> result) {
        if(node == null) return;
        int newTarget = target - node.val;
        currList.add(node.val);
        if (newTarget == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(currList));
        } else {
            pathSum(node.left, newTarget, currList, result);
            pathSum(node.right, newTarget, currList, result);
        }
        currList.remove(currList.size() - 1);
    }
}
