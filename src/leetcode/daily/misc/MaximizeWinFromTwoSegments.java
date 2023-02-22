package daily.misc;

public class MaximizeWinFromTwoSegments {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int start = 0, end = 0,count = 0, maxTillNow = prizePositions[0] + k;
        while (end < n) {
            if(prizePositions[end] > maxTillNow) {
                if(count > firstMax) {
                    secondMax = firstMax;
                    firstMax = count;
                } else if (count > secondMax) {
                    secondMax = count;
                }

                while (start < n - 1 && prizePositions[end] > maxTillNow) {
                    count--;
                    maxTillNow = prizePositions[start + 1] + k;
                    start++;
                }
            } else {
                count++;
            }
            end++;
        }

        if(count > firstMax) {
            secondMax = firstMax;
            firstMax = count;
        } else if (count > secondMax) {
            secondMax = count;
        }

        return firstMax + secondMax;
    }
}
