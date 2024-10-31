package daily.sep24;

import java.util.Arrays;
import java.util.List;

public class Day16MinimumTimeDifference {
    private final Pair start = new Pair("00:00");
    private final Pair end = new Pair("24:00");

    class Pair implements Comparable<Pair> {
        int hr;
        int min;
        public Pair(String time) {
            String[] split = time.split(":");
            this.hr = Integer.parseInt(split[0]);
            this.min = Integer.parseInt(split[1]);
        }


        @Override
        public int compareTo(Pair o) {
            return this.hr == o.hr ? Integer.compare(this.min, o.min) : Integer.compare(this.hr, o.hr);
        }
    }

    public int diffClockWise(Pair small, Pair big) {
        int diffOne = diff(big, end), diffTwo = diff(start, small);
        return diffOne + diffTwo;
    }

    public int diff(Pair small, Pair big) {
        return (big.hr - small.hr) * 60 + big.min - small.min;
    }

    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() == 1) return 0;
        Pair[] times = new Pair[timePoints.size()];
        for(int i=0; i<timePoints.size(); i++) {
            times[i] = new Pair(timePoints.get(i));
        }

        Arrays.sort(times);

        int minDiff = Math.min(diff(times[0], times[times.length - 1]), diffClockWise(times[0], times[times.length - 1]));
        for(int i=0; i<times.length - 1; i++) {
            Pair first = times[i], second = times[i + 1];
            int currDiff = Math.min(diff(first, second), diffClockWise(first, second));
            minDiff = Math.min(minDiff, currDiff);
        }

        return minDiff;
    }
}
