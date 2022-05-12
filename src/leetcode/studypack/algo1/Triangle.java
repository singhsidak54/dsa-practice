package leetcode.studypack.algo1;

import java.util.List;

// Problem Link - https://leetcode.com/problems/triangle/
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] minPathSum = new int[triangle.get(triangle.size() - 1).size()];
        minPathSum[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++) {
            for(int j=triangle.get(i).size() - 1; j>= 0; j--) {
                if(j==0) {
                    minPathSum[j] += triangle.get(i).get(j);
                } else if(j == triangle.get(i).size() - 1) {
                    minPathSum[j] = minPathSum[j - 1] + triangle.get(i).get(j);
                } else {
                    minPathSum[j] = Math.min(minPathSum[j], minPathSum[j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<minPathSum.length; i++) {
            if(minPathSum[i] < ans)
                ans = minPathSum[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
