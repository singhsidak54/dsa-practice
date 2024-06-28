package daily.apr23;

import java.util.Arrays;

public class Day2SuccessfulPairsOfSpellsAndPotions {
    public int searchInsertPositionFromEnd(int[] potions, int target) {
        int l = 0, r = potions.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(potions[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return potions.length - l;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        Arrays.sort(potions);

        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int required = (int) Math.ceil(success/(spells[i] * 1.0));
            ans[i] = searchInsertPositionFromEnd(potions, required);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day2SuccessfulPairsOfSpellsAndPotions obj = new Day2SuccessfulPairsOfSpellsAndPotions();
        int[] spells = {5,1,3}, potions = {1,2,3,4,5};
        System.out.println(Arrays.toString(obj.successfulPairs(spells, potions, 7)));
    }
}
