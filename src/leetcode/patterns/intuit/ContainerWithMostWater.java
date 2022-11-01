package patterns.intuit;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            int curr = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, curr);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
