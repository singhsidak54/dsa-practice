package bs1;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = -1, index2 = -1;
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int cSum = numbers[l] + numbers[h];
            if(cSum == target) {
                index1 = l + 1;
                index2 = h + 1;
                break;
            } else if (cSum < target) {
                l++;
            } else {
                h--;
            }
        }
        return new int[] {index1, index2};
    }
}
