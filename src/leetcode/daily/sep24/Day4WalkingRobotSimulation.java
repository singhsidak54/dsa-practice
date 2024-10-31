package daily.sep24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day4WalkingRobotSimulation {
    public int euclideanDistance(int x, int y) {
        return x * x + y * y;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int max = euclideanDistance(0, 0);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] obs : obstacles) {
            if(!map.containsKey(obs[0])) map.put(obs[0], new HashSet<>());
            map.get(obs[0]).add(obs[1]);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] currentPosition = {0, 0};
        int currentDir = 0;

        for(int command : commands) {
            if (command == -1) currentDir = (currentDir + 1) % 4;
            else if (command == -2) currentDir = (currentDir + 3) % 4;
            else {
                while (command-- > 0) {
                    int nextX = currentPosition[0] + dirs[currentDir][0], nextY = currentPosition[1] + dirs[currentDir][1];
                    if(map.getOrDefault(nextX, new HashSet<>()).contains(nextY)) break;
                    currentPosition[0] = nextX;
                    currentPosition[1] = nextY;
                }

                max = Math.max(euclideanDistance(currentPosition[0], currentPosition[1]), max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] commands = {-2,-1,-2,3,7};
        int[][] obs = {{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}};
        Day4WalkingRobotSimulation obj = new Day4WalkingRobotSimulation();
        System.out.println(obj.robotSim(commands, obs));
    }
}
