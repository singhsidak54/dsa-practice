package algo2;

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int count = 0;
        int j = 0, p = 1;
        for(int i=0; i<nums.length; i++) {
            p *= nums[i];
            while(p >= k && j <= i) {
                p = p/nums[j++];
            }
            count += i - j + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
