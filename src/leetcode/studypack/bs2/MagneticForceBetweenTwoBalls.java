package bs2;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0, h = position[position.length - 1] - position[0], mid;

        while (l < h) {
            mid = h - (h - l)/2;
            int countBalls = 1, lastBallAt = 0;

            for(int i=1; i< position.length; i++) {
                if(position[i] - position[lastBallAt] >= mid) {
                    countBalls++;
                    lastBallAt = i;
                }
            }

            if(countBalls < m) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[] {5,4,3,2,1,1000000000}, 2));
    }
}
