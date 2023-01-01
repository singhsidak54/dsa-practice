package daily.dec22.weekly;

public class Week3CampusBikesII {
    int smallestDist;
    boolean[] visited;

    public int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public void assignBikesHelper(int[][] workers, int workerIndex, int[][] bikes, int currentDistance) {
        if(workerIndex == workers.length) {
            smallestDist = Math.min(smallestDist, currentDistance);
            return;
        }

        if(currentDistance >= smallestDist) {
            return;
        }

        for(int bikeIndex=0; bikeIndex<bikes.length; bikeIndex++) {
            if(!visited[bikeIndex]) {
                visited[bikeIndex] = true;
                assignBikesHelper(workers, workerIndex + 1, bikes, currentDistance + distance(workers[workerIndex], bikes[bikeIndex]));
                visited[bikeIndex] = false;
            }
        }
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        smallestDist = Integer.MAX_VALUE;
        visited = new boolean[workers.length];

        assignBikesHelper(workers, 0, bikes, 0);
        return smallestDist;
    }
}
