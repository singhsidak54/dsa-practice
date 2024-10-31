package daily.sep24;

import java.util.HashSet;
import java.util.Set;

public class Day6DeleteNodesFromLinkedListPresentInArray {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> removeSet = new HashSet<>();
        for(int num : nums) removeSet.add(num);

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, prev = dummy;

        while (curr != null) {
            if(removeSet.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        Day6DeleteNodesFromLinkedListPresentInArray obj = new Day6DeleteNodesFromLinkedListPresentInArray();
        head = obj.modifiedList(nums, head);
        System.out.println(1);
    }
}
