package ds2;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for(int i=0; i<edges.size(); i++) {
            seen[edges.get(i).get(1)] = true;
        }

        for(int i=0; i<n; i++) {
            if(!seen[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
