package daily.apr23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day8CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static HashMap<Integer, Node> map;

    public static Node backtrack(Node node) {
        Node copy = new Node(node.val);
        map.put(node.val, copy);

        for(Node next : node.neighbors) {
            if(map.containsKey(next.val)) {
                copy.neighbors.add(map.get(next.val));
            } else {
                copy.neighbors.add(backtrack(next));
            }
        }
        return copy;
    }
    public static Node cloneGraph(Node node) {
        map = new HashMap<>();
        return backtrack(node);
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        two.neighbors.add(one);

        one.neighbors.add(four);
        four.neighbors.add(one);


        three.neighbors.add(two);
        two.neighbors.add(three);

        three.neighbors.add(four);
        four.neighbors.add(three);

        Node copy = cloneGraph(one);
        System.out.println('a');
    }
}
