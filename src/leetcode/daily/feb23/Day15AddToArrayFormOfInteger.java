package daily.feb23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day15AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int carry = k, i = num.length - 1;
        while (i >= 0) {
            int toAdd = num[i--] + carry;
            result.add(toAdd % 10);
            carry = toAdd / 10;
        }

        while (carry != 0) {
            result.add(carry % 10);
            carry = carry / 10;
        }

        Collections.reverse(result);
        return result;
    }
}
