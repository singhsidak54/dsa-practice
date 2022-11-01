package daily.oct22;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Day13DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
