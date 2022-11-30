package daily.nov22;

import java.util.Stack;

public class Day9OnlineStockSpanAlternative {
    private class Node {
        int price;
        int span;
        Node(int price) {
            this.price = price;
            this.span = 1;
        }
    }

    Stack<Node> stack;
    public Day9OnlineStockSpanAlternative() {
        stack = new Stack<>();
    }

    public int next(int price) {
        Node temp = new Node(price);
        while (!stack.isEmpty() && temp.price >= stack.peek().price) {
            temp.span += stack.peek().span;
            stack.pop();
        }
        stack.push(temp);
        return temp.span;
    }
}
