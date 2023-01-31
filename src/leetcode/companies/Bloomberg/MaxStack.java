package companies.Bloomberg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxStack {
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    TreeMap<Integer, List<Node>> nodesMap;
    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
        nodesMap = new TreeMap<>();
    }

    public void push(int x) {
        List<Node> currValNodes = nodesMap.getOrDefault(x, new ArrayList<>());

        // create a new node. Modify next of prev last and prev of tail
        Node prevLast = tail.prev;
        Node newLast = new Node(x, prevLast, tail);
        prevLast.next = newLast;
        tail.prev = newLast;

        currValNodes.add(newLast);
        nodesMap.put(x, currValNodes);
    }

    public int pop() {
        // delete node from tail
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;

        // delete node from nodesMap
        List<Node> currValNodes = nodesMap.get(last.val);
        if(currValNodes.size() == 1) {
            nodesMap.remove(last.val);
        } else {
            currValNodes.remove(currValNodes.size() - 1);
            nodesMap.put(last.val, currValNodes);
        }

        return last.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return nodesMap.lastKey();
    }

    public int popMax() {
        Map.Entry<Integer, List<Node>> lastEntry = nodesMap.lastEntry();
        List<Node> maxEntryNodes = lastEntry.getValue();
        Node latestMaxNode = maxEntryNodes.remove(maxEntryNodes.size() - 1);

        latestMaxNode.prev.next = latestMaxNode.next;
        latestMaxNode.next.prev = latestMaxNode.prev;

        if(maxEntryNodes.size() == 0) {
            nodesMap.remove(lastEntry.getKey());
        } else {
            nodesMap.put(lastEntry.getKey(), maxEntryNodes);
        }

        return latestMaxNode.val;
    }
}
