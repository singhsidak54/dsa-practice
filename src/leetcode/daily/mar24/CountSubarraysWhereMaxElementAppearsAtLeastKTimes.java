package daily.mar24;

import java.util.ArrayList;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int max = 0, totalOccur = 0, n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                totalOccur = 1;
            } else if(nums[i] == max) {
                totalOccur += 1;
            }
        }

        if(totalOccur < k) return ans;
        int start = 0, end = 0, currOccur = 0;
        while(end < n) {
            int num = nums[end++];
            if(num == max) {
                currOccur++;
            }

            while(currOccur == k) {
                ans += (n - end + 1);
                int left = nums[start++];
                if(left == max) {
                    currOccur--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82};
        System.out.println(countSubarrays(nums, 2));
    }
}
