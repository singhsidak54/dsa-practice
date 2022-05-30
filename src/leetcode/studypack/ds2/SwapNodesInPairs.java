package ds2;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = head;
        while(node!=null && node.next!= null) {
            prev.next = node.next;
            node.next = node.next.next;
            prev.next.next = node;
            prev = node;
            node = node.next;
        }
        return dummy.next;
    }
}
