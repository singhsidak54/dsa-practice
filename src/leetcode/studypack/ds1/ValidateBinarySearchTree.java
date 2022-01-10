package leetcode.studypack.ds1;

import java.util.ArrayList;
import java.util.List;

// Problem Link - https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public static void getInorder(TreeNode node, List<Integer> inorderList) {
        if(node == null)
            return;

        getInorder(node.left, inorderList);
        inorderList.add(node.val);
        getInorder(node.right, inorderList);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        getInorder(root, inorderList);
        for(int i=1; i<inorderList.size(); i++) {
            if(inorderList.get(i) <= inorderList.get(i - 1))
                return false;
        }
        return true;
    }

    public static boolean isValidBST2Helper(TreeNode node, long minValue, long maxValue) {
        if(node == null) return true;

        if(node.val >= maxValue || node.val <= minValue) return false;

        return isValidBST2Helper(node.left, minValue, node.val) && isValidBST2Helper(node.right, node.val, maxValue);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
