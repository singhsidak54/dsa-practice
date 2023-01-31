package daily.jan23;

public class Day7GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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
}
