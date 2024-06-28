package Scaler.LinkedList;

public class ReorderList {
    public static ListNode reverseList(ListNode A) {
        if(A == null) return null;
        ListNode prev = null;

        while(A.next != null) {
            ListNode next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }

        A.next = prev;
        return A;
    }

    public ListNode reorderList(ListNode A) {
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //return slow.val;

        ListNode reverseList = reverseList(slow.next);
        slow.next = null;

        ListNode curr = A;
        while (reverseList != null) {
            ListNode next = curr.next;
            curr.next = reverseList;

            reverseList = reverseList.next;
            curr.next.next = next;
            curr = next;
        }

        return A;
    }
}
