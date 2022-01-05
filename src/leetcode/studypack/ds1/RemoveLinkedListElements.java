package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == val) {
                if(prev != null) {
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    head = head.next;
                    curr = head;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);

        ListNode temp = removeElements(head, 5);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
