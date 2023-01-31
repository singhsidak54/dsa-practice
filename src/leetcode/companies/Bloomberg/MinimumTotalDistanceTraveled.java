package companies.Bloomberg;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinimumTotalDistanceTraveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        long ans = 0;
        TreeMap<Integer, Integer> factoriesMap = new TreeMap<>();
        for(int[] f : factory) {
            factoriesMap.put(f[0], factoriesMap.getOrDefault(f[0], 0) + f[1]);
        }

        for(int robotLocation : robot) {
            Map.Entry<Integer, Integer> ceilEntry = factoriesMap.ceilingEntry(robotLocation);
            Map.Entry<Integer, Integer> floorEntry = factoriesMap.floorEntry(robotLocation);

            if(ceilEntry == null) {
                ans += Math.abs(robotLocation - floorEntry.getKey());
                if(floorEntry.getValue() == 1) {
                    factoriesMap.remove(floorEntry.getKey());
                } else {
                    factoriesMap.put(floorEntry.getKey(), floorEntry.getValue() - 1);
                }
            } else if (floorEntry == null) {
                ans += Math.abs(robotLocation - ceilEntry.getKey());
                if(ceilEntry.getValue() == 1) {
                    factoriesMap.remove(ceilEntry.getKey());
                } else {
                    factoriesMap.put(ceilEntry.getKey(), ceilEntry.getValue() - 1);
                }
            } else {
                long ceilDist = Math.abs(robotLocation - ceilEntry.getKey());
                long floorDist = Math.abs(robotLocation - floorEntry.getKey());

                if(floorDist > ceilDist) {
                    ans += ceilDist;
                    if(ceilEntry.getValue() == 1) {
                        factoriesMap.remove(ceilEntry.getKey());
                    } else {
                        factoriesMap.put(ceilEntry.getKey(), ceilEntry.getValue() - 1);
                    }
                } else {
                    ans += floorDist;
                    if(floorEntry.getValue() == 1) {
                        factoriesMap.remove(floorEntry.getKey());
                    } else {
                        factoriesMap.put(floorEntry.getKey(), floorEntry.getValue() - 1);
                    }
                }
            }
        }

        return ans;
    }
}
