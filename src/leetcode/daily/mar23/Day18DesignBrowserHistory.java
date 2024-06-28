package daily.mar23;

public class Day18DesignBrowserHistory {
    class Node {
        String page;
        Node prev;
        Node next;

        public Node(String page) {
            this.page = page;
            this.prev = null;
            this.next = null;
        }
    }

    Node node;
    public Day18DesignBrowserHistory(String homepage) {
        node = new Node(homepage);
    }

    public void visit(String url) {
        Node next = new Node(url);
        node.next = next;
        next.prev = node;

        node = next;
    }

    public String back(int steps) {
        while(node.prev != null && steps > 0) {
            node = node.prev;
            steps--;
        }

        return node.page;
    }

    public String forward(int steps) {
        while(node.next != null && steps > 0) {
            node = node.next;
            steps--;
        }

        return node.page;
    }
}
