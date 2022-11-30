package daily.nov22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Stack;

public class Day19ErectTheFence {
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        Stack<int[]> stack = new Stack<>();

        for(int[] tree : trees) {
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2), stack.get(stack.size() - 1), tree) < 0) {
                stack.pop();
            }
            stack.push(tree);
        }

        stack.pop();
        for(int i=trees.length-1; i>=0; i--) {
            while (stack.size() >= 2 && orientation(stack.get(stack.size() - 2), stack.get(stack.size() - 1), trees[i]) < 0) {
                stack.pop();
            }
            stack.push(trees[i]);
        }

        HashSet<int[]> ans = new HashSet<>(stack);
        return ans.toArray(new int[ans.size()][]);
    }
}
