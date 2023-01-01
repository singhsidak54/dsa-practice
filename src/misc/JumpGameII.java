package misc;

public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int currentEnd = 0, currentMax = 0, jumps = 0;
        for(int i=0; i<nums.length-1 && currentEnd<nums.length-1; i++) {
            currentMax = Math.max(currentMax, nums[i] + i);
            if(currentEnd == i) {
                jumps++;
                currentEnd = currentMax;
            }
        }

        return jumps;
    }
}
