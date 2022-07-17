package bs2;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for(int pile : piles) {
            if(pile > max) {
                max = pile;
            }
        }

        int l = 1, r = max, reqH, mid;
        while (l < r) {
            reqH = 0;
            mid = l + (r - l)/2;

            for(int pile : piles) {
                reqH += pile / mid;

                if(pile % mid != 0) {
                    reqH++;
                }
            }

            if(reqH > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
