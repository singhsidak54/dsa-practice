package lc75l2;

import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        char operation = '+';
        int currNum = 0;

        for(int i=0; i<sArray.length; i++) {
            char c = sArray[i];

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }

            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == sArray.length - 1) {
                if(operation == '+') {
                    stack.add(currNum);
                } else if (operation == '-') {
                    stack.add(-currNum);
                } else if (operation == '/') {
                    stack.add(stack.pop()/currNum);
                } else if (operation == '*') {
                    stack.add(stack.pop() * currNum);
                }

                operation = c;
                currNum = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public int calculate2(String s) {
        int result = 0, lastNum = 0;
        char[] sArray = s.toCharArray();
        char operation = '+';
        int currNum = 0;

        for(int i=0; i<sArray.length; i++) {
            char c = sArray[i];
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }

            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == sArray.length - 1) {
                if(operation == '+' || operation == '-') {
                    result += lastNum;
                    lastNum = (operation == '+') ? currNum : -currNum;
                } else if (operation == '*') {
                    lastNum = lastNum * currNum;
                } else if (operation == '/') {
                    lastNum = lastNum / currNum;
                }

                currNum = 0;
                operation = c;
            }
        }

        return result + lastNum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
