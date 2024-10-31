package daily.sep24;

public class Day7LinkedListInBinaryTree {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class TreeNode {
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

    public boolean helper2(ListNode node, TreeNode treeNode) {
        if(node == null) return true;
        if(treeNode == null) return false;
        if(node.val != treeNode.val) return false;

        return helper2(node.next, treeNode.left) || helper2(node.next, treeNode.right);
    }

    public boolean helper(ListNode node, TreeNode treeNode) {
        if(node == null) return true;
        if(treeNode == null) return false;
        if(treeNode.val == node.val && helper2(node, treeNode)) {
            return true;
        }

        return helper(node, treeNode.left) || helper(node, treeNode.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head, root);
    }
}
