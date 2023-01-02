package daily.jan23.weekly;

import java.util.HashSet;
import java.util.Set;

public class Week1ConfusingNumber {
    public boolean confusingNumber(int n) {
        int temp = n;
        Set<Integer> invalid = new HashSet<>();
        invalid.add(2);
        invalid.add(3);
        invalid.add(4);
        invalid.add(5);
        invalid.add(7);

        int ans = 0;
        while (temp != 0) {
            int digit = temp % 10;
            temp = temp/10;

            int rotated = digit;
            if(invalid.contains(digit)) {
                return false;
            } else if (digit == 6) {
                rotated = 9;
            } else if (digit == 9) {
                rotated = 6;
            }

            ans = ans * 10;
            ans += rotated;
        }

        return ans != n;
    }
}
