package daily;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, end = head;

        while (n-- > 0) {
            end = end.next;
        }

        if(end == null) {
            return head.next;
        }

        while (end.next != null) {
            curr = curr.next;
            end = end.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}
