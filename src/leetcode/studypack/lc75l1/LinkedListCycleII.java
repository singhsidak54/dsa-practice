package lc75l1;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }

        if(slow != fast) {
            return null;
        }

        ListNode curr = head;
        while (curr != slow) {
            curr = curr.next;
            slow = slow.next;
        }

        return curr;
    }
}
