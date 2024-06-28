package Scaler.LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode ptr = A;

        while (ptr != null) {
            ListNode dummy = ptr;
            while (dummy != null && ptr.val == dummy.val) {
                dummy = dummy.next;
            }

            ptr.next = dummy;
            ptr = ptr.next;
        }

        return A;
    }
}
