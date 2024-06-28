package daily.mar23;

import java.util.ArrayList;
import java.util.List;

public class Day11ConvertSortedListToBinarySearchTree {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    public TreeNode dfs(List<Integer> sortedList, int left, int right) {
        if(left > right) {
            return null;
        }

        if(left == right) {
            return new TreeNode(sortedList.get(left));
        }

        int mid = left + (right - left)/2;

        TreeNode leftNode = dfs(sortedList, left, mid - 1);
        TreeNode rightNode = dfs(sortedList, mid + 1, right);

        return new TreeNode(sortedList.get(mid), leftNode, rightNode);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        List<Integer> sortedList = new ArrayList<>();
        while (head != null) {
            sortedList.add(head.val);
            head = head.next;
        }

        return dfs(sortedList, 0, sortedList.size() - 1);
    }
}
