package contests.bw99;

import java.util.*;

public class Q3 {
    public static int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> exclusiveRanges = new ArrayList<>();

        int currStart = ranges[0][0], currEnd = ranges[0][1], i = 1, n = ranges.length;
        while (i < n) {
            if(ranges[i][0] <= currEnd) {
                currEnd = Math.max(ranges[i][1], currEnd);
            } else {
                exclusiveRanges.add(new int[] {currStart, currEnd});
                currStart = ranges[i][0];
                currEnd = ranges[i][1];
            }
            i++;
        }

        exclusiveRanges.add(new int[] {currStart, currEnd});

        int mod = 1_000_000_000 + 7;
        int ans = 1;
        for(int j=0; j<exclusiveRanges.size(); j++) {
            ans = (ans << 1) % mod;
        }
        return ans;
    }

    public static int modularExponentiation(int x, int n) {
        int modulo = 1_000_000_007;
        long product = 1;
        long p = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                product = product * p % modulo;
            }
            p = (p * p % modulo);
            n >>= 1;
        }
        return (int) product;
    }

    public static void main(String[] args) {
        int[][] arr = {{57,92},{139,210},{306,345},{411,442},{533,589},{672,676},{801,831},{937,940},{996,1052},{1113,1156},{1214,1258},{1440,1441},{1507,1529},{1613,1659},{1773,1814},{1826,1859},{2002,2019},{2117,2173},{2223,2296},{2335,2348},{2429,2532},{2640,2644},{2669,2676},{2786,2885},{2923,2942},{3035,3102},{3177,3249},{3310,3339},{3450,3454},{3587,3620},{3725,3744},{3847,3858},{3901,3993},{4100,4112},{4206,4217},{4250,4289},{4374,4446},{4510,4591},{4675,4706},{4732,4768},{4905,4906},{5005,5073},{5133,5142},{5245,5309},{5352,5377},{5460,5517},{5569,5602},{5740,5791},{5823,5888},{6036,6042},{6096,6114},{6217,6262},{6374,6394},{6420,6511},{6564,6587},{6742,6743},{6797,6877},{6909,6985},{7042,7117},{7141,7144},{7276,7323},{7400,7456},{7505,7557},{7690,7720},{7787,7800},{7870,7880},{8013,8031},{8114,8224},{8272,8328},{8418,8435},{8493,8537},{8600,8704},{8766,8812},{8839,8853},{9032,9036},{9108,9189},{9222,9291},{9344,9361},{9448,9502},{9615,9673},{9690,9800},{9837,9868},{85,96},{145,202},{254,304},{372,411},{534,551},{629,692},{727,787},{861,944},{1041,1084},{1133,1174},{1260,1307},{1339,1358},{1478,1548},{1580,1618},{1694,1814},{1848,1891},{1936,1990},{2058,2130}};
        System.out.println(countWays(arr));
    }
}
