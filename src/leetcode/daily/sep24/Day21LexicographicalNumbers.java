package daily.sep24;

import java.util.ArrayList;
import java.util.List;

public class Day21LexicographicalNumbers {

    public void helper(int n, int limit, List<Integer> res) {
        if (n > limit) return;

        res.add(n);

        for (int i=0; i<=9; i++) {
            int next = n * 10 + i;
            helper(next, limit, res);
            if (next > limit) break;
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=1; i<10; i++) {
            helper(i, n, res);
        }
        return res;
    }

    public List<Integer> lexicalOrderIterative(int n) {
        List<Integer> res = new ArrayList<>();
        int currentNumber = 1;
        for(int i=0; i<n; i++) {
            res.add(currentNumber);
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber > n) {
                    currentNumber /= 10;
                }

                currentNumber++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Day21LexicographicalNumbers obj = new Day21LexicographicalNumbers();
        System.out.println(obj.lexicalOrder(130));
    }
}
