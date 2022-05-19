package ds2;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if(rowIndex == 0) return prev;
        List<Integer> current = null;
        for(int i=1; i<=rowIndex; i++) {
            current = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i)
                    current.add(1);
                else
                    current.add(prev.get(j) + prev.get(j-1));
            }
            prev = current;
        }

        return current;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i=1; i<=rowIndex; i++) {
            result.add(1);
            for(int j=i-1; j>=1; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow2(0));
    }
}
