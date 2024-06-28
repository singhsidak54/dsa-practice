package Scaler.LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null) return B;
        if(B == null) return A;

        if(A.val > B.val) return mergeTwoLists(B, A);

        ListNode currA = A.next, currB = B;

        ListNode head = A, curr = head;

        while (currA != null && currB != null) {
            if(currA.val < currB.val) {
                curr.next = currA;
                currA = currA.next;
            } else {
                curr.next = currB;
                currB = currB.next;
            }

            curr = curr.next;
        }

        if(currA != null) {
            curr.next = currA;
        }

        if (currB != null) {
            curr.next = currB;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(5);

        ListNode B = new ListNode(3);
        B.next = new ListNode(6);
        B.next.next = new ListNode(10);

        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode res = obj.mergeTwoLists(A, B);
        System.out.println('a');
    }
}
