package daily.oct24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day2RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        // de duplicate
        Set<Integer> distinct = new HashSet<>();
        for (int num : arr) {
            distinct.add(num);
        }

        // sort
        int[] sorted = new int[distinct.size()];
        int j = 0;
        for(int num : distinct) {
            sorted[j++] = num;
        }
        Arrays.sort(sorted);

        // store sorted index
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<sorted.length; i++) {
            if(indexMap.containsKey(sorted[i])) continue;
            indexMap.put(sorted[i], i);
        }

        // get sorted index
        int[] ans = new int[arr.length];
        for(int i=0; i<ans.length; i++) {
            ans[i] = indexMap.get(arr[i]) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day2RankTransformOfAnArray obj = new Day2RankTransformOfAnArray();
        int[] arr = {37,12,28,9,100,56,80,5,12};
        System.out.println(Arrays.toString(obj.arrayRankTransform(arr)));
    }
}
