package companies.Bloomberg;

import java.util.*;

public class DesignALeaderboard {
    HashMap<Integer, Integer> playerScoreHistory;
    TreeMap<Integer, Integer> scoresList;
    public DesignALeaderboard() {
        playerScoreHistory = new HashMap<>();
        scoresList = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        int prevScore = playerScoreHistory.getOrDefault(playerId, 0);
        if(prevScore != 0) {
            reset(playerId);
        }

        playerScoreHistory.put(playerId, score + prevScore);
        int newCount = scoresList.getOrDefault(score + prevScore, 0) + 1;
        scoresList.put(score + prevScore, newCount);
    }

    public int top(int K) {
        int currentDone = 0, topKSum = 0;
        for(Map.Entry<Integer, Integer> entry : scoresList.entrySet()) {
            if(currentDone + entry.getValue() > K) {
                topKSum += (entry.getKey() * (K - currentDone));
                break;
            } else {
                topKSum += (entry.getKey() * entry.getValue());
                currentDone += entry.getValue();
            }
        }

        return topKSum;
    }

    public void reset(int playerId) {
        int playerScore = playerScoreHistory.get(playerId);
        int newCount = scoresList.get(playerScore) - 1;
        if(newCount == 0) {
            scoresList.remove(playerScore);
        } else {
            scoresList.put(playerScore, newCount);
        }
        playerScoreHistory.remove(playerId);
    }

    public static void main(String[] args) {
        DesignALeaderboard obj = new DesignALeaderboard();
        obj.addScore(1,13);
        obj.addScore(2,93);
        obj.addScore(3,84);
        obj.addScore(4,6);
        obj.addScore(5,89);
        obj.addScore(6,31);
        obj.addScore(7,7);
        obj.addScore(8,1);
        obj.addScore(9,98);
        obj.addScore(10,42);
        System.out.println(obj.top(5));
        obj.reset(1);
        obj.reset(2);
        obj.addScore(3,76);
        obj.addScore(4,68);
        System.out.println(obj.top(1));
    }
}
