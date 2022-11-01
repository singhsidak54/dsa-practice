package ps1;

public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int manhattanDistance(int a, int b, int x, int y) {
        return Math.abs(x - a) + Math.abs(y - b);
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE, ans = -1;
        for(int i=0; i<points.length; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                int currDist = manhattanDistance(points[i][0], points[i][1], x, y);
                if(currDist < minDist) {
                    minDist = currDist;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
