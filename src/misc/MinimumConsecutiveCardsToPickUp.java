package misc;

import java.util.HashMap;

public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        int minCards = Integer.MAX_VALUE, currMinCards;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<cards.length; i++) {
            if(map.containsKey(cards[i])) {
                currMinCards = i - map.get(cards[i]) + 1;
                minCards = Math.min(minCards, currMinCards);
                map.put(cards[i], i);
            }
            map.put(cards[i], i);
        }

        return minCards == Integer.MAX_VALUE ? -1 : minCards;
    }
}
