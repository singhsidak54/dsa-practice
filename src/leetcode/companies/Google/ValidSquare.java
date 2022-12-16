package companies.Google;


import java.util.Arrays;
import java.util.Comparator;

public class ValidSquare {
    public int distance(int[] p1, int[] p2) {
        return (int) Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = { p1, p2, p3, p4 };
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }

                return Integer.compare(o1[0], o2[0]);
            }
        });

        return distance(points[0], points[1]) != 0
                && distance(points[0], points[1]) == distance(points[1], points[3])
                && distance(points[1], points[3]) == distance(points[3], points[2])
                && distance(points[3], points[2]) == distance(points[2], points[0])
                && distance(points[0], points[3]) == distance(points[1], points[2]);
    }
}
