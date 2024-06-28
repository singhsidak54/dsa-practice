package Scaler.LinkedList;

public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        ListNode curr = A, prev = null;
        while (curr != null && curr.next != null) {
            ListNode one = curr;
            ListNode two = curr.next;

            one.next = two.next;
            two.next = one;

            if(prev == null) {
                A = two;
            } else {
                prev.next = two;
            }

            prev = one;
            curr = one.next;
        }

        return A;
    }
}
