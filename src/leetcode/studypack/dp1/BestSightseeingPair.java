package dp1;

public class BestSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0, currScore = 0, maxTillNow = values[0], maxIndex = 0;
        for(int i=1; i<values.length; i++) {
            currScore = maxTillNow + values[i] + maxIndex - i;
            if(values[i] > maxTillNow - i + maxIndex) {
                maxTillNow = values[i];
                maxIndex = i;
            }
            maxScore = Math.max(maxScore, currScore);
        }

        return maxScore;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int maxScore = 0, currMax = values[0] - 1;
        for(int i=1; i<values.length; i++) {
            maxScore = Math.max(maxScore, values[i] + currMax);
            currMax = Math.max(values[i], currMax) - 1;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[] {6,3,7,4,7,6,6,4,9}));
    }
}
