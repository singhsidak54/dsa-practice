package daily.mar23;

public class Day8KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1_000_000_001, m;

        while(l < r) {
            m = l + (r - l)/2;
            int hrs = 0;
            for(int pile : piles) {
                hrs += (int)(Math.ceil(pile/(double)m));
            }

            if(hrs > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(1/(double)2));
    }
}
