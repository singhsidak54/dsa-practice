package daily.misc;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> dp = triangle.get(n-1);
        for(int i=n-2; i >=0; i--) {
            List<Integer> currentList = triangle.get(i);
            for(int j=0; j<currentList.size(); j++) {
                int min = Math.min(dp.get(j), dp.get(j+1));
                currentList.set(j, currentList.get(j) + min);
            }
            dp = currentList;
        }

        return dp.get(0);
    }
}
