package algo1;

// Problem Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        while(n != 0) {
            ptr = ptr.next;
            n--;
        }

        if(ptr == null)
            return head.next;

        ListNode temp = head;
        while(ptr.next != null) {
            temp = temp.next;
            ptr = ptr.next;
        }


        temp.next = temp.next.next;
        return head;
    }
}
