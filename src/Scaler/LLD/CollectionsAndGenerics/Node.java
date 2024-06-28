package Scaler.LLD.CollectionsAndGenerics;

import java.util.Iterator;

public class Node implements Iterable<Integer> {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator(this);
    }

    static class NodeIterator implements Iterator<Integer> {
        Node root;

        public NodeIterator(Node node) {
            this.root = node;
        }

        @Override
        public boolean hasNext() {
            return root != null;
        }

        @Override
        public Integer next() {
            Integer current = root.data;
            root = root.next;
            return current;
        }
    }
}