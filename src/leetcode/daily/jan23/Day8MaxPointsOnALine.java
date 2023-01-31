package daily.jan23;

import java.util.HashMap;

public class Day8MaxPointsOnALine {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    public int maxPoints(int[][] points) {
        if(points.length < 3) {
            return points.length;
        }
        int solution = 0;
        for(int i=0; i<points.length; i++) {
            int max = 0, overlap=0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=i+1; j<points.length; j++) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if(deltaX == 0 && deltaY == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                deltaX = deltaX/gcd;
                deltaY = deltaY/gcd;

                map.put(deltaX + "," + deltaY, map.getOrDefault(deltaX + "," + deltaY, 0) + 1);
                max = Math.max(max, map.get(deltaX + "," + deltaY));
            }

            solution = Math.max(solution, max + overlap + 1);
        }

        return solution;
    }
}
