package contests.bw99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {
    public static int splitNum(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num = num/10;
        }

        if(digits.size() == 1) {
            return digits.get(0);
        }

        Collections.sort(digits);
        int num1 = digits.get(0), num2 = digits.get(1);

        for(int i=2; i<digits.size(); i+=2) {
            num1 = num1 * 10 + digits.get(i);
            if(i + 1 < digits.size()) {
                num2 = num2 * 10 + digits.get(i+1);
            }
        }

        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println(splitNum(68743));
    }
}
