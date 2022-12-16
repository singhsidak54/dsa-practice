package companies.Bloomberg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GasStation {

    public static boolean canCompleteCircuitFromIndex(int[] gas, int[] cost, int index) {
        int currentGas = 0;
        for(int i = index; i < gas.length; i++) {
            currentGas = currentGas + gas[i] - cost[i];
            if(currentGas < 0) {
                return false;
            }
        }

        for(int i=0; i < index; i++) {
            currentGas = currentGas + gas[i] - cost[i];
            if(currentGas < 0) {
                return false;
            }
        }

        return true;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        for(int i=0; i<n; i++) {
            if(gas[i] - cost[i] >= 0) {
                pq.add(new int[] {gas[i] - cost[i], i});
            }
        }

        if(pq.isEmpty()) return -1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(canCompleteCircuitFromIndex(gas, cost, curr[1])) {
                return curr[1];
            }
        }

        return -1;
    }

    public static int canCompleteCircuitGenius(int[] gas, int[] cost) {
        int totalTank = 0, currTank = 0, startPosition = 0;

        for(int i=0; i<gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if(currTank < 0) {
                startPosition = i + 1;
                currTank = 0;
            }
        }

        if(totalTank < 0) return -1;
        return startPosition;
    }
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
