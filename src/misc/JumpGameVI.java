package misc;

public class JumpGameVI {
    public static int maxResult(int[] nums, int k) {
        int currentEnd = 0, currentScore = nums[0] + nums[nums.length - 1];
        while (currentEnd < nums.length - 1) {
            int maxEndIndex = currentEnd + 1;
            for(int j=currentEnd+2; j<Math.min(nums.length - 1, currentEnd + k + 1); j++) {
                if(nums[j] >= nums[maxEndIndex]) {
                    maxEndIndex = j;
                }
            }
            currentScore += nums[maxEndIndex];
            currentEnd = maxEndIndex;
        }

        return currentScore;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,-2,4,-7,3};
        System.out.println(maxResult(arr, 2));
    }
}
