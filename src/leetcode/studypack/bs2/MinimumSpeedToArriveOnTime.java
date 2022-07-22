package bs2;

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10_000_000 + 1, m;
        double currH;
        while (l < r) {
            currH = 0;
            m = l + (r - l) / 2;

            for (int i = 0; i < dist.length - 1; i++) {
                currH += (int) (dist[i] + m - 1) / m;
            }

            currH += ((double) dist[dist.length - 1]) / m;

            if (currH > hour) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l == 10_000_000 + 1 ? -1 : l;
    }
}
