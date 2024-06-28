package Scaler.Hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class SortArrayInGivenOrder {

    class CustomSort implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int one = map.getOrDefault(o1, Integer.MAX_VALUE);
            int two = map.getOrDefault(o2, Integer.MAX_VALUE);

            if(one == Integer.MAX_VALUE && two == Integer.MAX_VALUE) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(one, two);
        }
    }

    HashMap<Integer, Integer> map;
    public int[] solve(int[] A, int[] B) {
        map = new HashMap<>();
        for(int i=0; i<B.length; i++) {
            map.put(B[i], i);
        }

        Integer[] ACopy = new Integer[A.length];
        for(int i=0; i<A.length; i++) {
            ACopy[i] = A[i];
        }

        Arrays.sort(ACopy, new CustomSort());

        for(int i=0; i<A.length; i++) {
            A[i] = ACopy[i];
        }
        return A;
    }
}
