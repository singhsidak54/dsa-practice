package contests.w333;

import java.util.Arrays;
public class CountTheNumberOfSquareFreeSubsets {
    static boolean isSquareFree(int n)
    {
        if (n % 2 == 0)
            n = n / 2;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i = i + 2)
        {
            if (n % i == 0)
            {
                n = n / i;

                if (n % i == 0)
                    return false;
            }
        }

        return true;
    }

    public int squareFreeSubsets(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(isSquareFree(nums[i])) {
               count++;
            }
        }

        return ((int)Math.pow(2, count) - 1) % 1_000_000_007;
    }
}
