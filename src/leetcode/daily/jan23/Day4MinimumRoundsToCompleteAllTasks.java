package daily.jan23;

import java.util.HashMap;
import java.util.Map;

public class Day4MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> difficultyCount = new HashMap<>();
        for(int diff : tasks) {
            difficultyCount.put(diff, difficultyCount.getOrDefault(diff, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : difficultyCount.entrySet()) {
            int count = entry.getValue();

            if(count == 1) return -1;
            if(count % 3 == 0) {
                ans += (count/3);
            } else {
                ans += (count/3) + 1;
            }
        }

        return ans;
    }
}
