package daily.sep24;

import java.util.Arrays;

public class Day13XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorPrefixes = new int[arr.length + 1];

        for(int i=0; i<arr.length; i++) {
            xorPrefixes[i + 1] = xorPrefixes[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int[] q = queries[i];
            res[i] = xorPrefixes[q[1] + 1] ^ xorPrefixes[q[0]];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] q = {{0,1},{1,2},{0,3},{3,3}};
        Day13XORQueriesOfASubarray obj = new Day13XORQueriesOfASubarray();
        System.out.println(Arrays.toString(obj.xorQueries(arr, q)));
    }
}
