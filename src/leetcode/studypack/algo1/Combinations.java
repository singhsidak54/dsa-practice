package algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link - https://leetcode.com/problems/combinations/
public class Combinations {
    public static void combineHelper(List<List<Integer>> result, List<Integer> curr, int i, int k, int n) {
        if(k == 0) {
            result.add(List.copyOf(curr));
            return;
        }

        for(int j=i; j<=n-k+1; j++) {
            curr.add(j);
            combineHelper(result, curr, j+1, k-1, n);
            curr.remove(curr.size() - 1);
        }
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4,2);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
