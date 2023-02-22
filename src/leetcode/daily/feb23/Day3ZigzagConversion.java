package daily.feb23;

import java.util.ArrayList;
import java.util.List;

public class Day3ZigzagConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> result = new ArrayList<>();
        for(int j=0; j<numRows; j++) {
            result.add(new StringBuilder());
        }
        int i = 0;

        while (i < s.length()) {
            // traverse from top to bottom
            int j = 0;
            while (i < s.length() && j < numRows) {
                result.get(j).append(s.charAt(i));
                i++;
                j++;
            }

            // traverse diagonally from bottom to top
            j -= 2;
            while (i < s.length() && j > 0) {
                result.get(j).append(s.charAt(i));
                i++;
                j--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder row : result) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Day3ZigzagConversion obj = new Day3ZigzagConversion();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
    }
}
