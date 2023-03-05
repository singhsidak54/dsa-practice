package daily.mar23;

public class Day4CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = -1, iMin = -1, iMax = -1;
        long ans = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > maxK || nums[i] < minK) {
                start = i;
            }

            if(nums[i] == minK) {
                iMin = i;
            }

            if(nums[i] == maxK) {
                iMax = i;
            }

            ans += Math.max(0L, Math.min(iMin, iMax) - start);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day4CountSubarraysWithFixedBounds obj = new Day4CountSubarraysWithFixedBounds();
        int[] arr = {1,1,1,1};
        System.out.println(obj.countSubarrays(arr, 1, 1));
    }
}
