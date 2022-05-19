package ds2;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums)
            ans ^= n;
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,2,4};
        System.out.println(singleNumber(a));
    }
}
