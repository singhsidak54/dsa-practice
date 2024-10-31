package daily.sep24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5FindMissingObservations {
    public boolean dfs(int sum, int size, List<Integer> res) {
        if(sum == 0) {
            return res.size() == size;
        } else if(sum < 0 || res.size() > size) return false;


        for(int i=1; i<=6; i++) {
            res.add(i);
            if(dfs(sum - i, size, res)) return true;
            res.removeLast();
        }

        return false;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumTillNow = 0;
        for(int roll : rolls) {
            sumTillNow += roll;
        }

        int remainSum = mean * (n + rolls.length) - sumTillNow;
        if (remainSum > n * 6 || remainSum < n) return new int[0];
        int[] res = new int[n];
        int equalPart = remainSum/n, extraOneCount = remainSum % n;
        Arrays.fill(res, equalPart);
        for(int i=0; i<extraOneCount; i++) {
            res[i] += 1;
        }

        int s = 0;
        for(int num : res) {
            s += num;
        }

        return res;
    }

    public static void main(String[] args) {
        Day5FindMissingObservations obj = new Day5FindMissingObservations();
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5}, 4, 40)));
    }
}
