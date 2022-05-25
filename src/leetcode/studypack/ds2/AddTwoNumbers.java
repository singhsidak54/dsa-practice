package ds2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode result = null;
        ListNode temp = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = 0, l2Val = 0;
            if(l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int sum = l1Val + l2Val + carry;
            if(carry > 0) {
                carry = 0;
            }
            if(sum/10 > 0) {
                carry = sum/10;
                sum = sum%10;
            }
            if(result == null) {
                result = new ListNode(sum);
                temp = result;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
        }
        return result;
    }
}
