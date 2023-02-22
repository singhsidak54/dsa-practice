package daily.feb23;

public class Day23CapacityToShipPackagesWithinDDays {
    public int daysRequired(int[] weights, int maxWeight) {
        int days = 1, currWeight = 0;
        for(int i=0; i<weights.length; i++) {
            if(currWeight + weights[i] > maxWeight) {
                days++;
                currWeight = weights[i];
            } else {
                currWeight += weights[i];
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int max = 0, total = 0;
        for(int i=0; i<weights.length; i++) {
            max = Math.max(max, weights[i]);
            total += weights[i];
        }

        int l = max, r = total + 1, m = 0;
        while(l < r) {
            m = l + (r - l)/2;

            int daysReq = daysRequired(weights, m);
            if(daysReq > days) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
