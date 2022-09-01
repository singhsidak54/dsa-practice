package gt1;

import java.util.*;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;

        if(jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity)
            return true;

        return targetCapacity % (GCD(jug1Capacity, jug2Capacity)) == 0;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public boolean canMeasureWater2(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;

        if(jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity)
            return true;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        visited.add(0 + "," + 0);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int a = curr[0], b = curr[1];

            if(a + b == targetCapacity) return true;

            List<int[]> states = new ArrayList<>();

            states.add(new int[] {0, b});
            states.add(new int[] {a, 0});
            states.add(new int[] {jug1Capacity, b});
            states.add(new int[] {a, jug2Capacity});
            states.add(new int[] {Math.max(0, a - jug2Capacity + b), Math.min(jug2Capacity, b + a)});
            states.add(new int[] {Math.min(jug1Capacity, a + b), Math.max(0, b - jug1Capacity + a)});

            for(int[] move : states) {
                String nextState = move[0] + "," + move[1];
                if(visited.contains(nextState)) continue;
                queue.add(move);
                visited.add(nextState);
            }
        }

        return false;
    }
}
