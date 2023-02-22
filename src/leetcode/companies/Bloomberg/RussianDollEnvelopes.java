package companies.Bloomberg;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int longestIncreasingSubsequence(int[][] arr) {
        int[] tails = new int[arr.length];
        int size = 0;
        for(int i=0; i<arr.length; i++) {
            int low = 0, high = size;
            while (low < high) {
                int mid = low + (high - low)/2;
                if(tails[mid] < arr[i][1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            tails[low] = arr[i][1];
            if(low == size) {
                size++;
            }
        }

        return size;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        return longestIncreasingSubsequence(envelopes);
    }

    public static void main(String[] args) {
        RussianDollEnvelopes obj = new RussianDollEnvelopes();
        int[][] envs = {{1,1},{1,1},{1,1}};
        System.out.println(obj.maxEnvelopes(envs));
    }
}
