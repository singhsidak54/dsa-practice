package Scaler.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for(ListNode node : a) {
            if(node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
