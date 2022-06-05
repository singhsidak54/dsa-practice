package algo2;

import java.util.HashSet;

public class HappyNumber {
    private static int toSquareOfDigits(int n) {
        int res = 0;
        while(n != 0) {
            int t = n % 10;
            n = n/10;
            res += t * t;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1) {
            if(!set.add(n)) {
                return false;
            }
            n = toSquareOfDigits(n);
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        while (fast != 1) {
            slow = toSquareOfDigits(slow);
            fast = toSquareOfDigits(toSquareOfDigits(fast));
            if(slow == fast && fast != 1) {
                return false;
            }
        }
        return true;
    }
}
