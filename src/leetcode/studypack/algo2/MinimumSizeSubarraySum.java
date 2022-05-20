package algo2;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int i=0, start=0, sum=0;
        while(i<nums.length) {
            sum += nums[i];
            while(sum >= target && start <= i) {
                minLength = Math.min(minLength, i - start + 1);
                sum = sum - nums[start];
                start++;
            }
            i++;
        }

        if(minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(14, new int[]{1,1,1,1,1,1,1,1}));
    }
}
