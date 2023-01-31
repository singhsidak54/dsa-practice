package companies.Bloomberg;

import java.util.Stack;

public class DesignBrowserHistory {
    Stack<String> current;
    Stack<String> forward;
    public DesignBrowserHistory(String homepage) {
        current = new Stack<>();
        forward = new Stack<>();
        current.push(homepage);
    }

    public void visit(String url) {
        forward.clear();
        current.push(url);
    }

    public String back(int steps) {
        while (steps > 0 && current.size() > 1) {
            forward.push(current.pop());
            steps--;
        }

        return current.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !forward.isEmpty()) {
            current.push(forward.pop());
            steps--;
        }

        return current.peek();
    }
}
