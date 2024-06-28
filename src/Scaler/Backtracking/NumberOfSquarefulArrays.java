package Scaler.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSquarefulArrays {

    int count;

    public boolean validate(List<Integer> curr) {
        for(int i=1; i<curr.size(); i++) {
            int sum = curr.get(i - 1) + curr.get(i);
            int sqrt = (int)Math.sqrt(sum);

            if(sqrt * sqrt != sum) return false;
        }

        return true;
    }

    public void helper(int size, List<Integer> curr, HashMap<Integer, Integer> counter) {
        if(curr.size() == size) {
            if(validate(curr)) count++;
        }

        if(!validate(curr)) return;
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey(), count = entry.getValue();
            if(count == 0) continue;

            curr.add(key);
            counter.put(key, count - 1);
            helper(size, curr, counter);
            counter.put(key, count);
            curr.remove(curr.size() - 1);
        }
    }

    public int solve(int[] A) {
        if(A.length == 1) return 0;
        count = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int num : A) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        helper(A.length, new ArrayList<>(), counter);
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 8, 17};
        NumberOfSquarefulArrays obj = new NumberOfSquarefulArrays();
        System.out.println(obj.solve(A));
    }
}
