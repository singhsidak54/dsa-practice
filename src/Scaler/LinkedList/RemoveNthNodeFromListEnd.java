package Scaler.LinkedList;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode bth = A;
        while (bth != null && B != 0) {
            bth = bth.next;
            B--;
        }

        if(bth == null) {
            return A.next;
        }

        ListNode ptr = A;
        while (bth.next != null) {
            ptr = ptr.next;
            bth = bth.next;
        }

        ptr.next = ptr.next.next;
        return A;
    }
}
