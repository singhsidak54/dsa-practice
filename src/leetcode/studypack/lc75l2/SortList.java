package lc75l2;

public class SortList {
    public ListNode getMid(ListNode node) {
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        return fast;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (left != null && right != null) {
            if(left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if(left != null) {
            curr.next = left;
        } else if(right != null) {
            curr.next = right;
        }

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode nextStart = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(nextStart);

        head = merge(left, right);
        return head;
    }
}
