package Scaler.LinkedList;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class ReverseLinkedList {

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

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);

        ListNode rev = reverseList(A);
        System.out.println(1);
    }
}
