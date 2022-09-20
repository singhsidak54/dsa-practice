package lc75l2;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenStart = new ListNode(), evenEnd = evenStart, oddCurr = head;

        while (oddCurr.next != null && oddCurr.next.next != null) {
            evenEnd.next = oddCurr.next;
            evenEnd = evenEnd.next;
            oddCurr.next = oddCurr.next.next;
            oddCurr = oddCurr.next;
        }

        if(oddCurr.next != null) {
            evenEnd.next = oddCurr.next;
            evenEnd = evenEnd.next;
        }

        evenEnd.next = null;
        oddCurr.next = evenStart.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(oddEvenList(head));
    }
}
