package patterns.intuit;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val > list2.val) return mergeTwoLists(list2, list1);

        ListNode l1Curr = list1;
        while (l1Curr.next != null && list2 != null) {
            if(l1Curr.next.val > list2.val) {
                ListNode temp = list2;
                list2 = list2.next;
                temp.next = l1Curr.next;
                l1Curr.next = temp;
            }
            l1Curr = l1Curr.next;
        }

        if(list2 != null) {
            l1Curr.next = list2;
        }

        return list1;
    }
}
