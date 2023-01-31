package companies.Bloomberg;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length == 1) {
            return power < tokens[0] ? 0 : 1;
        }

        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1, score = 0, maxScore = 0;

        while (l < r) {
            while (l <= r && power >= tokens[l]) {
                power -= tokens[l];
                l++;
                score++;
            }

            maxScore = Math.max(maxScore, score);

            while (l < r && score > 1 && power < tokens[l]) {
                power += tokens[r];
                r--;
                score--;
            }
        }

        return maxScore;
    }
}
