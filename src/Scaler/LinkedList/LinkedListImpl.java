package Scaler.LinkedList;

public class LinkedListImpl {

    static LinkedList list = new LinkedList();
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        list.insert(position, value);
    }

    public static void delete_node(int position) {
        // @params position, integer
        list.delete(position);
    }

    public static void print_ll() {
        // Output each element followed by a space
        list.print();
    }



    static class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public LinkedList() {
            this.head = null;
        }

        public void insert(int pos, int val) {
            Node node = new Node(val);
            if(pos == 1) {
                node.next = head;
                head = node;
            } else {
                Node curr = head;
                while(pos != 2 && curr != null) {
                    curr = curr.next;
                    pos--;
                }

                if(pos != 2) return;

                node.next = curr.next;
                curr.next = node;
            }
        }

        public void delete(int position) {
            if(position == 1) {
                if(head == null) return;
                head = head.next;
                return;
            }
            Node curr = head;
            while(position > 2 && curr != null) {
                curr = curr.next;
                position--;
            }

            if(curr == null) return;
            curr.next = curr.next.next;
        }

        public void print() {
            StringBuilder str = new StringBuilder();
            Node curr = head;
            while (curr != null) {
                str.append(curr.value);
                str.append(' ');
                curr = curr.next;
            }

            str.deleteCharAt(str.length() - 1);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        insert_node(1, 23);
        insert_node(2, 24);
        print_ll();
        delete_node(1);
        print_ll();
    }
}
