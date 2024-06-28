package Scaler.Math;

import java.util.ArrayList;
import java.util.List;

public class ExcelColumn {
    public static String convertToTitle(int A) {
        char[] mapping = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        List<Integer> remainders = new ArrayList<>();
        while(A > 0) {
            remainders.add((A - 1) % 26);
            A = (A - 1)/26;
        }

        StringBuilder res = new StringBuilder();
        for(int col : remainders) {
            res.append(mapping[col]);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(943566));
    }
}
