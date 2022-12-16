package companies.Bloomberg;


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {};
    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};

public class FlattenAMultilevelDoublyLinkedList {
    public static Node getEnd(Node node) {
        while (node.next != null) {
           if(node.child != null) {
               node = dealWithChild(node);
           } else {
               node = node.next;
           }
        }

        if(node.child != null) {
            node = dealWithChild(node);
        }
        return node;
    }

    public static Node dealWithChild(Node node) {
        Node temp = node.next;

        // chane next pointer of node to child of node
        node.next = node.child;

        // change prev of node.child
        node.child.prev = node;

        // change child of node to null
        node.child = null;

        // move to child
        node = node.next;

        // get end pointer of child
        Node endOfChild = getEnd(node);

        // update next of child
        endOfChild.next = temp;

        // update prev of original node.next

        if(temp != null) {
            temp.prev = endOfChild;
            return temp;
        }

        return endOfChild;
    }

    public static Node flatten(Node head) {
        Node node = head;

        while (node != null) {
            if(node.child != null) {
                node = dealWithChild(node);
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public static Node flattenClean(Node head) {
        Node dummyHead = new Node();
        dummyHead.next = head;

        flattenDFS(dummyHead, head);
        dummyHead.next.prev = null;
        return dummyHead.next;
    }

    public static Node flattenDFS(Node prev, Node curr) {
        if(curr == null) return prev;

        prev.next = curr;
        curr.prev = prev;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        head.child = new Node();
        head.child.val = 2;

        head.child.child = new Node();
        head.child.child.val = 3;

        flattenClean(head);

        System.out.println("a");
    }
}
