package daily.feb23;

public class Day6ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0, j = n, k = 0;
        while (i < n) {
            res[k++] = nums[i++];
            res[k++] = nums[j++];
        }

        return res;
    }
}
