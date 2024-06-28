package Scaler.LinkedList;

public class RemoveLoopFromLinkedList {
    public ListNode solve(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }




        if(fast.next == null || fast.next.next == null) {
            return head;
        }

        ListNode node = head;

        while(true) {
            node = node.next;
            if(node == slow.next) {
                slow.next = null;
                break;
            }
            slow = slow.next;
        }

        return head;
    }
}
