package lc75l2;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            if (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if(-asteroid < stack.peek()) continue;
                int lastPopped = stack.pop();
                while (!stack.isEmpty() && lastPopped != -asteroid && stack.peek() > 0 && -asteroid >= stack.peek()) {
                    lastPopped = stack.pop();
                }

                if(lastPopped != asteroid && (stack.isEmpty() || stack.peek() < 0)) stack.add(asteroid);
            } else {
                stack.add(asteroid);
            }
        }

        int[] res = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
