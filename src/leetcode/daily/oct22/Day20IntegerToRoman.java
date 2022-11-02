package daily.oct22;

import java.util.HashMap;

public class Day20IntegerToRoman {
    public static int justSmaller(int n) {
        int[] temp = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int l = 1, r = temp.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(temp[m] <= n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return temp[l - 1];
    }

    public static String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            int curr = justSmaller(num);
            int times = num/curr;
            num = num - (curr * times);

            String temp = map.get(curr);
            temp = temp.repeat(times);
            ans.append(temp);
        }

        return ans.toString();
    }

    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (values[i] > num) {
                i++;
            }
            int times = num/values[i];
            num = num - (values[i] * times);
            result.append(romans[i].repeat(times));
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
