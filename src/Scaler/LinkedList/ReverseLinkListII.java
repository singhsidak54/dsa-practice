package Scaler.LinkedList;

public class ReverseLinkListII {

    public static ListNode reverseList(ListNode A) {
        ListNode prev = null;

        while(A.next != null) {
            ListNode next = A.next;
            A.next = prev;
            prev = A;
            A = next;
        }

        A.next = prev;
        return A;
    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode curr = A;
        int pos = 1;

        // get start of part B
        while (pos < B - 1) {
            curr = curr.next;
            pos++;
        }

        ListNode headB = A;
        if(B != 1) {
            headB = curr.next;
            curr.next = null;
            pos++;
        }

        ListNode tailA = B == 1 ? null : curr;
        curr = headB;
        while (pos != C) {
            curr = curr.next;
            pos++;
        }

        ListNode headC = curr.next;
        curr.next = null;

        ListNode tailB = headB;
        headB = reverseList(headB);

        ListNode res = tailA == null ? headB : A;
        if(tailA != null) {
            tailA.next = headB;
        }

        tailB.next = headC;
        return res;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);

        A = reverseBetween(A, 1,3);
        System.out.println(1);
    }
}
