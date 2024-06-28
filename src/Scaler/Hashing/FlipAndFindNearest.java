package Scaler.Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FlipAndFindNearest {
    public int[] solve(String A, int[][] B) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) == '1') {
                treeSet.add(i + 1);
            }
        }

        for(int[] query : B) {
            int type = query[0], idx = query[1];
            if(type == 1) {
                if(treeSet.contains(idx)) {
                    treeSet.remove(idx);
                } else {
                    treeSet.add(idx);
                }
            } else {
                Integer prev = treeSet.floor(idx);
                Integer next = treeSet.ceiling(idx);

                if(prev != null && next != null) {
                    int prevDist = idx - prev, nextDist = next - idx;
                    if(nextDist < prevDist) {
                        ans.add(next);
                    } else {
                        ans.add(prev);
                    }
                } else if(prev != null) {
                    ans.add(prev);
                } else if(next != null) {
                    ans.add(next);
                } else {
                    ans.add(-1);
                }
            }
        }


        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
