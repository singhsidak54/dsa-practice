package bs2;

public class SellDiminishingValuedColoredBalls {
    public static long ballsOrdered(int[] inventory, int k) {
        long res = 0;
        for(int inv : inventory) {
            if(inv > k) {
                res += inv - k;
            }
        }

        return res;
    }

    public static int maxProfit(int[] inventory, int orders) {
        int max = 0;
        for(int inv : inventory) {
            if(inv > max) {
                max = inv;
            }
        }

        int l = 0, r = max + 1, mid;
        while (l < r) {
            mid = l + (r - l)/2;
            if(ballsOrdered(inventory, mid) > orders) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l);
        long maxValue = 0;
        for(int inv : inventory) {
            if(inv < l) continue;
            maxValue += (long) (inv + l + 1) * (inv - l)/2;
            orders -= (inv - l);
        }

        maxValue += (long) orders * l;
        return (int) (maxValue % 1_000_000_007);
    }

    public static int maxProfit2(int[] inventory, int orders) {
        int max = 0;
        for(int inv : inventory) {
            if(inv > max) {
                max = inv;
            }
        }

        int lo=0, hi=max, mid=lo+(hi-lo)/2;
        while(lo<hi) {
            if(check(inventory, mid, orders)) lo=mid+1;
            else hi=mid;
            mid=lo+(hi-lo)/2;
        }
        System.out.println(lo);
        long res=0;
        for(int i=0;i<inventory.length;i++) {
            if(inventory[i]<=mid) continue;
            res+=((long)inventory[i]+(long)mid+1)*((long)(inventory[i]-mid))/2;
            orders-=(inventory[i]-mid);
        }
        res+=(long)orders*(long)mid;
        return (int)(res%1000000007);
    }

    public static boolean check(int[] inv, int n, int orders) {
        for(int i=0;i<inv.length&&orders>0;i++) orders-=Math.max(0, inv[i]-n);
        return orders<=0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037}, 598226067));
        System.out.println(maxProfit2(new int[] {701695700,915736894,35093938,364836059,452183894,951826038,861556610,441929847,842650446,858413011,457896886,35119509,776620034,396643588,83585103,681609037}, 598226067));
    }
}
