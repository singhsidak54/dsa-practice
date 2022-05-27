package ds2;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if(prev.next != curr && prev.next.val == curr.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }
        return dummy.next;
    }
}
