package companies.Bloomberg;


import java.util.HashMap;

public class LRUCache {
    class DLinkNode {
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;

        // add node to head
        public void addNode(DLinkNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        // remove a node from the list
        public void removeNode(DLinkNode node) {
            DLinkNode prev = node.prev;
            DLinkNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        // move a node to the head
        public void moveToHead(DLinkNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        // remove a node from the end
        public DLinkNode evictNode() {
            DLinkNode lastNode = tail.prev;
            this.removeNode(lastNode);
            return lastNode;
        }
    }

    DLinkNode head;
    DLinkNode tail;
    int size;
    int capacity;
    HashMap<Integer, DLinkNode> map;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if(this.map.containsKey(key)) {
            DLinkNode node = map.get(key);
            this.head.moveToHead(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        DLinkNode node = this.map.get(key);

        if(node == null) {
            node = new DLinkNode();
            node.key = key;
            node.val = value;

            this.head.addNode(node);
            this.map.put(key, node);
            this.size++;
            if(this.size > this.capacity) {
                this.size--;
                DLinkNode evicted = this.head.evictNode();
                this.map.remove(evicted.key);
            }
        } else {
            node.val = value;
            this.head.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
