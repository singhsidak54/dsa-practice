package daily.sep24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day29AllInOneDataStructure {
    class Node {
        int freq;
        Set<String> keys;
        Node prev;
        Node next;
        public Node(int freq) {
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }

    Node head;
    Node tail;
    Map<String, Node> nodes;

    public Day29AllInOneDataStructure() {
        this.head = new Node(0);
        this.tail = new Node(Integer.MAX_VALUE);
        this.nodes = new HashMap<>();

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void inc(String key) {
        Node node = nodes.get(key);
        if(node == null) {
            // get 1 freq node
            if(head.next != null && head.next.freq == 1) {
                head.next.keys.add(key);
            } else {
                node = new Node(1);
                node.keys.add(key);
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;

            }
            nodes.put(key, head.next);
        } else {
            node.keys.remove(key);
            // check if next node has freq 1 greater than this
            if(node.next != null && node.next.freq == node.freq + 1) {
                node.next.keys.add(key);
            } else {
                Node next = new Node(node.freq + 1);
                next.keys.add(key);
                next.prev = node;
                next.next = node.next;
                node.next.prev = next;
                node.next = next;
            }

            nodes.put(key, node.next);

            // remove node if req
            if(node.keys.isEmpty()) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public void dec(String key) {
        Node node = nodes.get(key);
        node.keys.remove(key);
        if(node.freq == 0) {
            nodes.remove(key);
        } else {
            if(node.prev.freq == node.freq - 1) {
                node.prev.keys.add(key);
            } else {
                Node prev = new Node(node.freq - 1);
                prev.keys.add(key);
                prev.prev = node.prev;
                prev.next = node;
                node.prev.next = prev;
                node.prev = prev;
            }

            nodes.put(key, node.prev);
        }
        // remove node if req
        if (node.keys.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private boolean isEmpty() {
        return this.head.next == this.tail;
    }

    public String getMaxKey() {
        return isEmpty() ? "" : this.tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return isEmpty() ? "" : this.head.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        Day29AllInOneDataStructure obj = new Day29AllInOneDataStructure();
        obj.inc("a");
        obj.inc("b");
        obj.inc("b");
        obj.inc("b");
        obj.inc("b");
        obj.dec("b");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        obj.inc("a");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }
}
