package daily.oct24;

import java.util.ArrayList;
import java.util.List;

public class Day17MaximumSwap {
    public void swap(StringBuilder str, int i, int j) {
        char a = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, a);
    }

    public int maximumSwap(int num) {
        if(num == 0) return 0;
        StringBuilder numStr = new StringBuilder(String.valueOf(num));
        int[] rightMaxIndex = new int[numStr.length()];

        // build rightMax
        int n = numStr.length(), i = n - 1;

        rightMaxIndex[i] = i;
        i--;
        while (i >= 0) {
            int digit = numStr.charAt(i) - '0', maxDigit = numStr.charAt(rightMaxIndex[i + 1]) - '0';
            if(digit > maxDigit) {
                rightMaxIndex[i] = i;
            } else {
                rightMaxIndex[i] = rightMaxIndex[i + 1];
            }
            i--;
        }


        int ans = num;
        i = 0;
        while (i < n) {
            int d = numStr.charAt(i) - '0', maxD = numStr.charAt(rightMaxIndex[i]) - '0';
            if (d < maxD) {
                swap(numStr, i, rightMaxIndex[i]);

                int candidate = Integer.parseInt(numStr.toString());
                ans = Math.max(ans, candidate);

                swap(numStr, i, rightMaxIndex[i]);
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day17MaximumSwap obj = new Day17MaximumSwap();
        System.out.println(obj.maximumSwap(22341345));
    }
}
