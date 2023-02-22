package contests.w333;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            int minId = Math.min(nums1[i][0], nums2[j][0]);
            int val = 0;

            if(nums1[i][0] == minId) {
                val += nums1[i][1];
                i++;
            }

            if(nums2[j][0] == minId) {
                val += nums2[j][1];
                j++;
            }

            result.add(new int[] {minId, val});
        }

        int total = result.size() + (n1 - i) + (n2 - j), ptr = 0;
        int[][] res = new int[total][2];
        for(int[] curr : result) {
            res[ptr++] = curr;
        }

        while (i < n1) {
            res[ptr++] = nums1[i++];
        }

        while (j < n2) {
            res[ptr++] = nums2[j++];
        }

        return res;
    }
}
