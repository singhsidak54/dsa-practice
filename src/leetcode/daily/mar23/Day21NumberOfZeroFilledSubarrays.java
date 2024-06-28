package daily.mar23;

public class Day21NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0;

        for(int num : nums) {
            if(num == 0) {
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }

        return ans;
    }
}
