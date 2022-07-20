package lc75l1;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        char[] sArray = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for(int i=sArray.length - 1; i>=0; i--) {
            if(sArray[i] == '[') {
                StringBuilder n = new StringBuilder();
                while (i > 0 && Character.isDigit(sArray[i-1])) {
                    n.insert(0, sArray[i-1]);
                    i--;
                }

                int k = Integer.parseInt(n.toString());
                StringBuilder currString = new StringBuilder();
                while (!stack.peek().equals("]")) {
                    currString.append(stack.pop());
                }
                stack.pop();
                stack.push(currString.toString().repeat(k));
            } else {
                stack.push(Character.toString(sArray[i]));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("10[a]"));
    }
}
