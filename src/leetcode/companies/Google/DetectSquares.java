package companies.Google;

public class DetectSquares {
    int[][] plane;
    public DetectSquares() {
        plane = new int[1001][1001];
    }

    public void add(int[] point) {
        plane[point[0]][point[1]] += 1;
    }

    private int getDistance(int y2, int y1) {
        return Math.abs(y2 - y1);
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 1001 && y >= 0 && y < 1001;
    }

    private int getCount(int x1, int y1, int x2, int y2, int distance) {
        int x3 = x1 + distance, y3 = y1, x4 = x2 + distance, y4 = y2;
        int count = 0;
        if(isValid(x2, y2) && isValid(x3, y3) && isValid(x4, y4)) {
            count = (plane[x2][y2] * plane[x3][y3] * plane[x4][y4]);
        }

        return count;
    }

    public int count(int[] point) {
        int qX = point[0], qY = point[1], count = 0;
        for(int i=0; i<1001; i++) {
            if(i == qY) continue;
            if(plane[qX][i] != 0) {
                int distance = getDistance(qY, i);
                count += getCount(qX, qY, qX, i, distance);
                count += getCount(qX, qY, qX, i, -distance);
            }
        }
        return count;
    }
}
