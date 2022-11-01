package contests.w316;

public class NumberOfSubarraysWithGCDEqualToK {
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            int cGCD = nums[i];
            for(int j=i; j<nums.length; j++) {
                cGCD = gcd(nums[i], cGCD);
                if(cGCD == k) {
                    ans++;
                }

                if(cGCD < k) {
                    break;
                }
            }
        }

        return ans;
    }
}
