package companies.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectSquaresWithoutConstraints {
    List<int[]> points;
    HashMap<String, Integer> countMap;
    public DetectSquaresWithoutConstraints() {
        points = new ArrayList<>();
        countMap = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        String key = point[0] + "@" + point[1];
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int ans = 0, qX = point[0], qY = point[1];
        for(int[] pt : points) {
            if(pt[0] != qX) continue;
            if(pt[1] == qY) continue;

            int sideLength = Math.abs(qY - pt[1]);

            int x3, x4, y3 = qY, y4 = pt[1];

            // squares to the left
            x3 = qX - sideLength;
            x4 = qX - sideLength;

            ans += (countMap.getOrDefault(x3 + "@" + y3, 0) * countMap.getOrDefault(x4 + "@" + y4, 0));

            // squares to the right
            x3 = qX + sideLength;
            x4 = qX + sideLength;

            ans += (countMap.getOrDefault(x3 + "@" + y3, 0) * countMap.getOrDefault(x4 + "@" + y4, 0));
        }

        return ans;
    }
}
