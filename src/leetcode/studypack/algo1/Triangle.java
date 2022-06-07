package algo1;

import java.util.List;

// Problem Link - https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size() - 2; i>=0; i--) {
            List<Integer> currRow = triangle.get(i);
            for(int j=0; j<triangle.get(i).size(); j++) {
                List<Integer> nextRow = triangle.get(i+1);
                currRow.set(j, Math.min(nextRow.get(j), nextRow.get(j+1)) + currRow.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
