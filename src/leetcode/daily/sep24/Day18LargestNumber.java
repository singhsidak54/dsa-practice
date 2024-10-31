package daily.sep24;

import java.util.Arrays;
import java.util.Comparator;

public class Day18LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String num : arr) {
            res.append(num);
        }

        // remove leading zeroes
        int index = 0;
        while (index < res.length() - 1 && res.charAt(index) == '0') {
            index++;
        }
        return res.substring(index);
    }

    public static void main(String[] args) {
        Day18LargestNumber obj = new Day18LargestNumber();
        int[] nums = {0, 0};
        System.out.println(obj.largestNumber(nums));
    }
}
