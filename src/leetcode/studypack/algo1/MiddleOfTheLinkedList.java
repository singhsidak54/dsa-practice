package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/middle-of-the-linked-list/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode ptr = head, fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            ptr = ptr.next;
            fastPtr = fastPtr.next.next;
        }

        return ptr;
    }
}
