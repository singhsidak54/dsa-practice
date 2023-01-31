package Scaler.Primer.Misc;

import java.util.ArrayList;
import java.util.List;

public class FoodPacketsDistribution {
    public static int shopCount(List<Integer> A, int perShop) {
        int count = 0;
        for(int population : A) {
            count += population/perShop;
        }

        return count;
    }

    public static int solve(ArrayList<Integer> A, int B) {
        long total = 0;
        int min = Integer.MAX_VALUE;
        for(int population : A) {
            total += population;
            min = Math.min(min, population);
        }

        if(total < B) return 0;

        int low = 1, high = min, mid;
        while (low < high) {
            mid = low + (high - low)/2 + 1;
            if(shopCount(A, mid) < B) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(9);
        arr.add(5);
        arr.add(4);
        System.out.println(solve(arr, 13));
    }
}
