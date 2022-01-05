package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode temp = reverseList(head);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
