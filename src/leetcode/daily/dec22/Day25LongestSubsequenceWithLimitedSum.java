package daily.dec22;

import java.util.Arrays;

public class Day25LongestSubsequenceWithLimitedSum {
    static int[] prefixSum;

    public static int query(int q) {
        int l = 0, r = prefixSum.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(prefixSum[m] > q) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<ans.length; i++) {
            ans[i] = query(queries[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};

        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }
}
