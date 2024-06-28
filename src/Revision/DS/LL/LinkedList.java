package Revision.DS.LL;


class Node {
    int data;
    Node next;

    public Node(int num) {
        this.data = num;
    }
}

class LinkedListImpl {
    Node head;

    public LinkedListImpl() {

    }

    public void addNode(int num) {
        // if head is null
        if(head == null) {
            this.head = new Node(num);
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = new Node(num);
        }
    }

    public void removeNode(int num) {
        if(head != null && head.data == num) {
            head = head.next;
            return;
        }

        Node curr = head;
        while(curr != null && curr.next != null) {
            if (curr.next.data == num) {
                Node nodeToRemove = curr.next;
                curr.next = nodeToRemove.next;
            }
        }
    }
}
public class LinkedList {
    Node head;


    // add node

    // remove node

    // find node
}
