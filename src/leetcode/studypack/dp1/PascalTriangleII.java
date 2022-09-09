package dp1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp;
        for(int i=0; i<=rowIndex; i++) {
            temp = new ArrayList<>(result);
            for(int j=1; j<i; j++) {
                result.set(j, temp.get(j) + temp.get(j-1));
            }
            result.add(1);
        }
        return result;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) {
            for(int j=i-1; j>0; j--) {
                result.set(j, result.get(j) + result.get(j-1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow2(3));
    }
}
