package daily.apr23;

import java.util.Stack;

public class Day12SimplifyPath {
    public String simplifyPath(String path) {
        Stack<StringBuilder> stack = new Stack<>();
        int i = 0, n = path.length();
        while (i < n) {
            char c = path.charAt(i);

            if(c == '/') {
                int j = i + 1;
                StringBuilder next = new StringBuilder();
                while (j < n && path.charAt(j) != '/') {
                    next.append(path.charAt(j));
                    j++;
                }

                i = j;

                if (next.length() == 0) continue;

                // if dots
                if (next.charAt(0) == '.') {
                    int count = 0;
                    int k = 0;
                    while (k < next.length() && next.charAt(k) == '.') {
                        count++;
                        k++;
                    }

                    if (k == next.length()) {
                        if(count > 2) {
                            stack.add(next);
                        } else if(count == 2 && !stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        stack.add(next.reverse());
                    }
                } else {
                    stack.add(next.reverse());
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append('/');
            result.append(stack.pop());
        }

        result.reverse();
        if(result.length() > 0 && result.charAt(result.length() - 1) == '/') {
            result.deleteCharAt(result.length() - 1);
        }

        result.insert(0, '/');
        return result.toString();
    }

    public static void main(String[] args) {
        Day12SimplifyPath obj = new Day12SimplifyPath();
        System.out.println(obj.simplifyPath("/home/.../"));
    }
}
