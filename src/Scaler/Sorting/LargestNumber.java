package Scaler.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(final int[] A) {
        String[] nums = new String[A.length];
        for(int i=0; i<A.length; i++) {
            nums[i] = String.valueOf(A[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });

        StringBuilder res = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--) {
            res.append(nums[i]);
        }

        int i=0;
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }

        return res.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412}));
    }
}
