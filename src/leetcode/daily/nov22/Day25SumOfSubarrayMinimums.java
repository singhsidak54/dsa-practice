package daily.nov22;

import java.util.Stack;

public class Day25SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        int mod = 1000000007;
        for(int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int mid = stack.pop();
                int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
                int nextSmaller = i;
                long count = (mid - previousSmaller) * (nextSmaller - mid) % mod;
                ans += (arr[mid] * count) % mod;
                ans = ans % mod;
            }
            stack.push(i);
        }

        int nextSmaller = arr.length;
        while (!stack.isEmpty()) {
            int mid = stack.pop();
            int previousSmaller = stack.isEmpty() ? -1 : stack.peek();
            long count = (mid - previousSmaller) * (nextSmaller - mid) % mod;
            ans += (arr[mid] * count) % mod;
            ans = ans % mod;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[] {11,81,94,43,3}));
    }
}
