package leetcode.studypack.algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Link - https://leetcode.com/problems/combinations/
public class Combinations {
    public static void combineHelper(int n, int k, int start,List<Integer> current, List<List<Integer>> sol) {
        if(current.size() == k) {
            sol.add(List.copyOf(current));
            return;
        }

        for (int i=start; i<=n; i++) {
            current.add(i);
            combineHelper(n,k,i + 1,current,sol);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineHelper(n, k,1,new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4,2);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
