package leetcode.studypack.ds1;

// Problem Link - https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        ListNode prev = null;
        ListNode curr = list1;
        while (curr != null && list2 != null) {
            if(curr.val > list2.val) {
                if(prev == null) {
                    list1 = list2;
                } else {
                    prev.next = list2;
                }
                ListNode temp = list2.next;
                list2.next = curr;
                prev = list2;
                list2 = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        if(list2 != null)
            prev.next = list2;
        return list1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);

        ListNode temp = mergeTwoLists(head, head2);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
