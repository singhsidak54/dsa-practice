package daily.dec22;

public class Day4MinimumAverageDifference {
    public static int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }

        int minAvgDiff = Integer.MAX_VALUE, n = nums.length, minAvgDiffIndex = -1;
        long sumTillNow = 0;
        for(int i=0; i<n; i++) {
            sumTillNow += nums[i];
            sum -= nums[i];

            int avgTillNow = (int) (sumTillNow/(i + 1));
            int avgOfRest = (i == n - 1) ? 0 : (int) (sum/(n - 1 - i));
            int currAvgDiff = Math.abs(avgOfRest - avgTillNow);

            if(currAvgDiff < minAvgDiff) {
                minAvgDiff = currAvgDiff;
                minAvgDiffIndex = i;
            }
        }

        return minAvgDiffIndex;
    }

    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[] {2,5,3,9,5,3}));
    }
}
