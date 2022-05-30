package ds2;

class MyLinkedList {
    private ListNode head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if(index > size) {
            return -1;
        }

        ListNode curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        ListNode node = new ListNode(val);
        if(index == 0) {
            if(head != null) {
                node.next = head;
            }
            head = node;
        } else {
            ListNode curr = head;
            for(int i=0; i<index-1; i++) {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index > size) {
            return;
        }

        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode curr = head;
        for(int i=0; i<index-1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));
    }
}
