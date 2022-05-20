package ds2;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 2) return false;
        int count = 2, seqMax = nums[0], low = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > seqMax) {
                count--;
                seqMax = nums[i];
            } else if(nums[i] > low){
                count = 1;
                seqMax = nums[i];
            } else {
                low = nums[i];
            }

            if(count == 0)
                return true;
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if(nums.length < 2) return false;
        int seqMax = Integer.MAX_VALUE, low = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > seqMax) {
                return true;
            } else if(nums[i] > low){
                seqMax = nums[i];
            } else {
                low = nums[i];
            }
        }
        return false;
    }
}
