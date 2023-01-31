package companies.Bloomberg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortIntegersByThePowerValue {

    HashMap<Integer, Integer> cache;

    public int power(int x) {
        if(x == 1) return 0;

        if(cache.containsKey(x)) {
            return cache.get(x);
        }

        if(x % 2 == 0) {
            cache.put(x, power(x/2) + 1);
        } else {
            cache.put(x, power(3 * x + 1) + 1);
        }

        return cache.get(x);
    }

    class Node {
        int x;
        int power;

        public Node(int x, int power) {
            this.x = x;
            this.power = power;
        }
    }
    public int getKth(int lo, int hi, int k) {
        cache = new HashMap<>();
        int n = hi - lo + 1;
        Node[] result = new Node[n];

        for(int i=lo; i<=hi; i++) {
            result[i - lo] = new Node(i, power(i));
        }

        Arrays.sort(result, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.power == o2.power) {
                    return Integer.compare(o1.x, o2.x);
                }

                return Integer.compare(o1.power, o2.power);
            }
        });

        return result[k - 1].x;
    }
}
