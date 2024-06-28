package Scaler.LinkedList;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode curr = head;

        // make next pointers
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;

        // make random pointers
        while (curr != null) {
            RandomListNode copy = curr.next;
            if(curr.random != null) {
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }

        // get list out
        RandomListNode copyList = new RandomListNode(-1);
        RandomListNode copyCurr = copyList;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr = curr.next.next;
            copyCurr = copyCurr.next;
        }

        return copyList.next;
    }

    public static void main(String[] args) {
        CopyList obj = new CopyList();
        RandomListNode list = new RandomListNode(1);
        list.next = new RandomListNode(2);
        list.next.next = new RandomListNode(3);

        list.random = list.next.next;
        list.next.random = list;
        list.next.next.random = list;

        RandomListNode copy = obj.copyRandomList(list);
        System.out.println(1);
    }
}
