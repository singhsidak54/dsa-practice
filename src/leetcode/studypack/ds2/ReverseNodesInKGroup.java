package ds2;

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode previousEnd = null, currentEnd;
        ListNode start = head;
        while(true) {
            int i = k;
            ListNode nextStart = start;
            while (nextStart != null && i != 0) {
                nextStart = nextStart.next;
                i--;
            }

            if(i != 0) {
                break;
            }

            currentEnd = start;
            ListNode prev = nextStart;

            while (start != nextStart) {
                ListNode temp = start.next;
                start.next = prev;
                prev = start;
                start = temp;
            }

            if(previousEnd == null) {
                head = prev;
            } else {
                previousEnd.next = prev;
            }
            previousEnd = currentEnd;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = reverseKGroup(head, 2);

        System.out.println(head);
    }
}
