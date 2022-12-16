package daily.dec22;

public class Day6OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode curr = head, evenHead = null, currEven = null;

        while (curr.next != null) {
            // get a reference to even node
            ListNode nextEven = curr.next;

            // update next pointer of odd node
            curr.next = curr.next.next;

            // add even node to even list
            if(evenHead == null) {
                evenHead = nextEven;
                currEven = evenHead;
            } else {
                currEven.next = nextEven;
                currEven = currEven.next;
            }
            currEven.next = null;

            if(curr.next == null) {
                break;
            } else {
                curr = curr.next;
            }
        }

        curr.next = evenHead;

        return head;
    }
}
