package daily.dec22;

import java.util.Stack;

public class Day18DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return ans;
    }

    public int[] dailyTemperaturesSpaceOptimised(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int hottest = 0;

        for(int i=n-1; i>=0; i--) {
            if(temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }

            int days = 1;
            while (temperatures[i + days] <= temperatures[i]) {
                days += ans[i + days];
            }

            ans[i] = days;
        }

        return ans;
    }
}
