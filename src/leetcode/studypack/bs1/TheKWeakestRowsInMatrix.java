package bs1;

import java.util.*;

public class TheKWeakestRowsInMatrix {
    public static int weakness(int[] row) {
        int l = 0, r = row.length - 1, m;
        if(row[l] == 0) {
            return row.length;
        }
        while (l < r) {
            m = l + (r-l)/2 + 1;
            if(row[m] == 1) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return row.length - l - 1;
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> weaknessMap = new HashMap<>();
        for(int i=0; i<mat.length; i++) {
            weaknessMap.put(i, weakness(mat[i]));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = weaknessMap.get(o2) - weaknessMap.get(o1);
                return diff == 0 ? o1 - o2 : diff;
            }
        });

        pq.addAll(weaknessMap.keySet());

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0},
                {0,0},
                {1,0}};

        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
