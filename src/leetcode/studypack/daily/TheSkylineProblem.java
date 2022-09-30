package daily;

import java.util.*;

public class TheSkylineProblem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> heightCount = new HashMap<>();

        for(int[] building : buildings) {
            heights.add(new int[] { building[0], building[2] });
            heights.add(new int[] { building[1], -building[2] });
        }

        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        int prev = 0;
        pq.offer(0);

        for(int i=0; i<heights.size(); i++) {
            int[] height = heights.get(i);
            if(height[1] < 0) {
                heightCount.put(-height[1], heightCount.get(-height[1]) - 1);
            } else {
                pq.offer(height[1]);
                heightCount.put(height[1], heightCount.getOrDefault(height[1], 0) + 1);
            }

            int currMax = pq.peek();
            while (currMax != 0 && heightCount.get(currMax) == 0) {
                pq.poll();
                currMax = pq.peek();
            }

            if(currMax == 0 && i != heights.size() - 1 && height[0] == heights.get(i+1)[0]) {
                int[] nextHeight = heights.get(i+1);
                if(prev == nextHeight[1]) {
                    continue;
                }
                res.add(Arrays.asList(nextHeight[0], nextHeight[1]));
                prev = nextHeight[1];
            } else if(prev != currMax) {
                res.add(Arrays.asList(height[0], currMax));
                prev = currMax;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10}};
        getSkyline(buildings);
    }
}
