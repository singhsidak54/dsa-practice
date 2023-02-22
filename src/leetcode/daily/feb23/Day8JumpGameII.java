package daily.feb23;

public class Day8JumpGameII {
    public int jump(int[] nums) {
        int currentMax = 0, maxTillNow = 0, jumps = 0;
        for(int i=0; i<nums.length - 1; i++) {
            maxTillNow = Math.max(maxTillNow, i + nums[i]);
            if(i == currentMax) {
                currentMax = maxTillNow;
                jumps++;
            }
        }

        return jumps;
    }
}
