package daily.sep24;

public class Day10InsertGreatestCommonDivisorsInLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int gcd = gcd(curr.val, curr.next.val);
            ListNode toInsert = new ListNode(gcd, curr.next);
            curr.next = toInsert;
            curr = curr.next.next;
        }

        return head;
    }
}
