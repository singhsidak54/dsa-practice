package daily.oct22;

public class Day3MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int timeLeft = 0, timeSum = neededTime[0];
        int n = colors.length(), currMax = neededTime[0];
        for(int i=1; i<n; i++) {
            if(colors.charAt(i) == colors.charAt(i-1)) {
                currMax = Math.max(currMax, neededTime[i]);
            } else {
                timeLeft += currMax;
                currMax = neededTime[i];
            }
            timeSum += neededTime[i];
        }

        timeLeft += currMax;
        return timeSum - timeLeft;
    }
}
