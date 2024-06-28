package daily.apr23;

import java.util.ArrayList;
import java.util.List;

public class Day15MaximumValueOfKCoinsFromPiles {


    public static int backtrack(List<List<Integer>> piles, int k, int currPile, int[][] dp) {
        if(k == 0) return 0;
        if(piles.size() == currPile) return 0;

        if(dp[currPile][k] != 0) {
            return dp[currPile][k];
        }

        int ans = 0;
        // skip the pile
        ans = Math.max(ans, backtrack(piles, k, currPile + 1, dp));

        // consider the pile
        List<Integer> pile = piles.get(currPile);
        int sum = 0;
        for(int i=0; i<Math.min(pile.size(), k); i++) {
            sum += pile.get(i);
            ans = Math.max(ans, sum + backtrack(piles, k - i - 1, currPile + 1, dp));
        }

        dp[currPile][k] = ans;
        return dp[currPile][k];
    }
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][k + 1];

        return backtrack(piles, k, 0, dp);
    }

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();

        List<Integer> pile1 = new ArrayList<>();
        pile1.add(1);
        pile1.add(100);
        pile1.add(15);

        List<Integer> pile2 = new ArrayList<>();
        pile2.add(1);
        pile2.add(100);
        pile2.add(15);

        piles.add(pile1);
        piles.add(pile2);

        System.out.println(maxValueOfCoins(piles, 2));
    }
}
