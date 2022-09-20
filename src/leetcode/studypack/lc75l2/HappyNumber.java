package lc75l2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n = n/10;
        }
        return digits;
    }

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if(visited.contains(n)) return false;

            visited.add(n);
            List<Integer> digits = getDigits(n);
            n = 0;
            for(int num : digits) {
                n += Math.pow(num, 2);
            }
        }

        return true;
    }
}
