package daily.nov22;

import java.util.*;

public class Day28FindPlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> played = new HashSet<>();
        HashMap<Integer, Integer> lossesCount = new HashMap<>();

        for(int[] match : matches) {
            played.add(match[0]);
            played.add(match[1]);

            lossesCount.put(match[1], lossesCount.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> onlyOneLoss = new ArrayList<>();

        List<Integer> playedList = new ArrayList<>(played);
        Collections.sort(playedList);

        for(Integer player : playedList) {
            int lossCount = lossesCount.getOrDefault(player, 0);
            if(lossCount == 0) {
                zeroLosses.add(player);
            } else if (lossCount == 1) {
                onlyOneLoss.add(player);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLosses);
        result.add(onlyOneLoss);

        return result;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{5,4}, {6,2}, {6,2}};
        System.out.println(findWinners(matches));
    }
}
