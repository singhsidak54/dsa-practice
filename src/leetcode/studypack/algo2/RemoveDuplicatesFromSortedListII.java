package algo2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3, new ListNode(3, new ListNode(5)));
        head = deleteDuplicates(head);
        System.out.println(1);
    }
}
