package dp1;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<Integer> dp = triangle.get(m-1);

        for(int i=m-2; i>=0; i--) {
            List<Integer> currentList = triangle.get(i);
            for(int j=0; j<currentList.size(); j++) {
                currentList.set(j, currentList.get(j) + Math.min(dp.get(j), dp.get(j+1)));
            }
            dp = currentList;
        }

        return dp.get(0);
    }
}
