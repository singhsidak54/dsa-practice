package lc75l2;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, end = head;

        while (n != 0) {
            end = end.next;
            n--;
        }

        if(end == null) return head.next;

        while (end.next != null) {
            end = end.next;
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }
}
