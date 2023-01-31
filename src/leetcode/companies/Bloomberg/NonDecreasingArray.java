package companies.Bloomberg;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean isModified = false;
        int curr = nums[0], minPrevCanGo = -100000;

        for(int i=1; i<nums.length; i++) {
            if(curr > nums[i]) {
                if(isModified) return false;
                isModified = true;
                curr = Math.max(minPrevCanGo, nums[i]);
            } else {
                minPrevCanGo = isModified ? nums[i] : curr;
                curr = nums[i];
            }
        }

        return true;
    }
}
