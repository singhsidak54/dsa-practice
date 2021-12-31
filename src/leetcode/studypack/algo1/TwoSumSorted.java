package leetcode.studypack.algo1;

import java.util.Arrays;

public class TwoSumSorted {
    public static int[] twoSum(int[] numbers, int target) {
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

    public static void main(String[] args) {
        int[] a = {2,3,4};
        System.out.println(Arrays.toString(twoSum(a, 6)));
    }
}
