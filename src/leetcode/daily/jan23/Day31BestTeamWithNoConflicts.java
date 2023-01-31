package daily.jan23;

import java.util.Arrays;
import java.util.Comparator;

public class Day31BestTeamWithNoConflicts {
    class Player {
        int score;
        int age;
        public Player(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }


    public int helper(Player[] players, int index, int minAgeRequired, Integer[][] dp) {
        if(index == players.length) {
            return 0;
        }

        if(dp[index][minAgeRequired] != null) {
            return dp[index][minAgeRequired];
        }

        dp[index][minAgeRequired] = Integer.MIN_VALUE;

        // max score if we consider this player
        if(players[index].age >= minAgeRequired) {
            dp[index][minAgeRequired] = players[index].score + helper(players, index + 1, players[index].age, dp);
        }

        // max score if we do not consider this player
        dp[index][minAgeRequired] = Math.max(dp[index][minAgeRequired], helper(players, index + 1, minAgeRequired, dp));

        return dp[index][minAgeRequired];
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int maxAge = 0;
        Player[] players = new Player[n];
        for(int i=0; i<n; i++) {
            players[i] = new Player(ages[i], scores[i]);
            maxAge = Math.max(maxAge, ages[i]);
        }

        Integer[][] dp = new Integer[n][maxAge];
        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.score == o2.score) {
                    return Integer.compare(o1.age, o2.age);
                }
                return Integer.compare(o1.score, o2.score);
            }
        });

        return helper(players, 0, 0, dp);
    }

    public int bestTeamScoreOptimised(int[] scores, int[] ages) {
        int n = scores.length;
        int maxScore = 0;
        Player[] players = new Player[n];
        for(int i=0; i<n; i++) {
            players[i] = new Player(ages[i], scores[i]);
        }

        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.age == o2.score) {
                    return Integer.compare(o1.score, o2.score);
                }
                return Integer.compare(o1.age, o2.age);
            }
        });

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = players[i].score;
            for(int j=i-1; j>=0; j--) {
                if(players[j].score <= players[i].score) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }

        return maxScore;
    }
}
