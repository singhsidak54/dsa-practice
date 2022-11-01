package patterns.intuit;

public class PalindromeLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);
        ListNode temp = head;

        while (secondHalf != null) {
            if(temp.val != secondHalf.val) {
                return false;
            }
            temp = temp.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}
