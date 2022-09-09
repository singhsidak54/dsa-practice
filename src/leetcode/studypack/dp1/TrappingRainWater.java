package dp1;

import java.util.Stack;

public class TrappingRainWater {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length, i=0, ans = 0;
        while (i < n) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) break;

                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(i);
            i++;
        }

        return ans;
    }

    public static int trap2(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, ans = 0;
        while (left < right) {
            if(height[left] < height[right]) {
                if(height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static int trap3(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans = 0;

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[n-i-1] = Math.max(rightMax[n-i], height[n-i-1]);
        }

        for(int i=1; i<n-1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap3(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
