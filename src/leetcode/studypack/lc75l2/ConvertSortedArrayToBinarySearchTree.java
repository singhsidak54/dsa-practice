package lc75l2;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
}
