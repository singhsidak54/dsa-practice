package daily.mar23;

public class Day20CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int req) {
        int count = 0, n = flowerbed.length;

        for(int i=0; i<n; i++) {
            if(flowerbed[i] == 1) continue;
            boolean left = i == 0 || flowerbed[i-1] == 0;
            boolean right = i == n - 1 || flowerbed[i+1] == 0;

            if(left && right) {
                count++;
                flowerbed[i] = 1;
            }
        }

        return count >= req;
    }
}
