package Scaler.Contest.AdvancedDSA4;


class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class Q1 {
    public ListNode solve(ListNode A) {
        ListNode dummy = new ListNode(-1), ptr = dummy;

        ListNode curr = A;
        while (curr != null) {
            if(curr.val % 2 == 0) {
                ptr.next = curr;
                curr = curr.next;
                ptr = ptr.next;
                ptr.next = null;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
