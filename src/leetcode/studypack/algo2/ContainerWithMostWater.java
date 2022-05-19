package algo2;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while(i < j) {
            int water = Math.min(height[i], height[j]) * (j - i);
            if(water > ans) ans = water;
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return ans;
    }
}
