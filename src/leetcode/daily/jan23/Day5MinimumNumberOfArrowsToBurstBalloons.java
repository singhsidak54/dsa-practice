package daily.jan23;

import java.util.Arrays;
import java.util.Comparator;

public class Day5MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int shots = 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int i = 1, currentEnd = points[0][1];
        while (i < points.length) {
            if(points[i][0] > currentEnd) {
                currentEnd = points[i][1];
                shots++;
            }
            i++;
        }

        return shots;
    }
}
