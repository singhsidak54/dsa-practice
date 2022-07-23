package bs2;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static int countBouquets(int[] bloomDay, int k, int day) {
        int result = 0, currAdj = 0;
        for(int bloom : bloomDay) {
            if(bloom > day) {
                currAdj = 0;
            } else {
                currAdj++;
            }

            if(currAdj == k) {
                result++;
                currAdj = 0;
            }
        }

        return result;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int flowersReq = m * k;
        if(flowersReq > bloomDay.length) {
            return -1;
        }

        int max = 0;
        for(int num : bloomDay) {
            if(num > max) {
                max = num;
            }
        }

        int l = 1, r = max, mid, currBouquets;
        while (l < r) {
            mid = l + (r - l)/2;

            currBouquets = countBouquets(bloomDay, k, mid);

            if(currBouquets < m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[] {1,10,3,10,2}, 3, 1));
    }
}
