package daily.oct24;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day16LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        res.repeat('0', 2);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        int[] forA = {a, 0}, forB = {b, 1}, forC = {c, 2};
        if(a != 0) pq.add(forA);
        if(b != 0) pq.add(forB);
        if(c != 0) pq.add(forC);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            char toAdd = (char) ('a' + curr[1]);
            int idx = res.length();
            if(res.charAt(idx - 1) == toAdd && res.charAt(idx - 2) == toAdd) {
                if (pq.isEmpty()) break;
                int[] nextGreater = pq.poll();
                char toAdd2 = (char) ('a' + nextGreater[1]);
                res.append(toAdd2);

                if(nextGreater[0] > 1) {
                    pq.add(new int[] {nextGreater[0] - 1, nextGreater[1]});
                }
            } else {
                res.append(toAdd);
                curr[0]--;
            }

            if(curr[0] > 0) {
                pq.add(new int[] {curr[0], curr[1]});
            }
        }

        return res.substring(2);
    }

    public static void main(String[] args) {
        Day16LongestHappyString obj = new Day16LongestHappyString();
        System.out.println(obj.longestDiverseString(1, 1,7));
    }
}
