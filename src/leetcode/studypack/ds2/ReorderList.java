package ds2;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow.next;
        ListNode next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        slow.next = prev;
        ListNode i = head, j = slow;
        while (i != j) {
            next = i.next;
            i.next = j.next;
            j.next = j.next.next;
            i.next.next = next;
            i = next;
        }
    }
}
