package daily.sep24;

public class Day8SplitLinkedListInParts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int partSize = size / k, partsWithExtra = size % k, i = 0;
        ListNode partStart = head, partEnd = head;

        while (partEnd != null) {
            int remainingPartSize = partSize;
            if (partsWithExtra > 0) {
                partsWithExtra--;
                remainingPartSize++;
            }

           while (partEnd != null && remainingPartSize-- > 1) {
               partEnd = partEnd.next;
           }

           res[i++] = partStart;
           partStart = partEnd.next;
           partEnd.next = null;
           partEnd = partStart;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        Day8SplitLinkedListInParts obj = new Day8SplitLinkedListInParts();
        ListNode[] res = obj.splitListToParts(head, 1);
        System.out.println(1);
    }
}
