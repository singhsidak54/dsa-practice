package companies.Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }

        ListNode ans = new ListNode();
        ListNode ptr = ans;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            ptr.next = curr;
            ptr = curr;
            if(curr.next != null) {
                pq.add(curr.next);
            }
        }

        return ans.next;
    }
}
