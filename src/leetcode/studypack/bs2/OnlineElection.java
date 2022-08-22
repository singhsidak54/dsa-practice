package bs2;

import java.util.ArrayList;
import java.util.HashMap;

public class OnlineElection {
    class Winner {
        int person;
        int time;
        public Winner(int person, int time) {
            this.person = person;
            this.time = time;
        }
    }

    ArrayList<Winner> winnersList;
    public OnlineElection(int[] persons, int[] times) {
        winnersList = new ArrayList<>();
        HashMap<Integer, Integer> voteFreqMap = new HashMap<>();

        //make persons[0] the first winner
        voteFreqMap.put(persons[0], 1);
        winnersList.add(new Winner(persons[0], times[0]));
        int currentWinner = 0;

        for(int i=1; i< persons.length; i++) {
            int p = persons[i];
            voteFreqMap.put(p, voteFreqMap.getOrDefault(p, 0) + 1);

            if(p != currentWinner && voteFreqMap.get(p) >= voteFreqMap.get(currentWinner)) {
                currentWinner = p;
                winnersList.add(new Winner(p, times[i]));
            }
        }
    }

    public int q(int t) {
        int l = 1, r = this.winnersList.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(this.winnersList.get(m).time > t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return this.winnersList.get(l - 1).person;
    }

    public static void main(String[] args) {
        OnlineElection obj = new OnlineElection(new int[] {0, 1, 1, 0, 0, 1, 0},
                                                new int[] {0, 5, 10, 15, 20, 25, 30});

        System.out.println(obj.q(3));
    }
}
