package misc;

import java.util.Stack;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                if(stack.isEmpty()) {
                    continue;
                }

                int width = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[curr];
                ans += boundedHeight * width;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap2(int[] height) {
        int left = 0, right = height.length - 1, ans = 0, leftMax = -1, rightMax = -1;
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
    public static void main(String[] args) {
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }
}
