package Scaler.LinkedList;

public class MiddleElementOfLinkedList {
    public int solve(ListNode A) {
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
}
