package lc75l2;

public class PalindromeLinkedList {
    public ListNode reverseList(ListNode end) {
        ListNode prev = null, curr = end, next;
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

        ListNode rev = reverseList(slow.next);

        while (rev !=  null) {
            if(head.val != rev.val) {
                return false;
            }

            head = head.next;
            rev = rev.next;
        }

        return true;
    }
}
