package patterns.amazon;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
