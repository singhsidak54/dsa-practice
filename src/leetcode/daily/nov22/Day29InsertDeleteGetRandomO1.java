package daily.nov22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Day29InsertDeleteGetRandomO1 {
    List<Integer> list;
    HashMap<Integer, Integer> indexes;
    Random rand;

    public Day29InsertDeleteGetRandomO1() {
        list = new ArrayList<>();
        indexes = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(indexes.containsKey(val)) {
            return false;
        }

        indexes.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!indexes.containsKey(val)) {
            return false;
        }

        int index = indexes.get(val);
        if(index != list.size() - 1) {
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            indexes.put(lastElement, index);
        }

        indexes.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
