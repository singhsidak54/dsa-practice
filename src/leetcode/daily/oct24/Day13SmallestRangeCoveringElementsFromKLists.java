package daily.oct24;

import java.util.*;

public class Day13SmallestRangeCoveringElementsFromKLists {
    public int[] getMinRange(int[] a, int[] b) {
        int diff1 = a[1] - a[0], diff2 = b[1] - b[0];
        if (diff1 == diff2) return a[0] < b[0] ? a : b;

        return diff1 < diff2 ? a : b;
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] curr = {-1000000, 1000000};

        for(int i=0; i<nums.size(); i++) {
            treeSet.add(new int[] {nums.get(i).get(0), i, 0});
        }

        curr = getMinRange(curr, new int[] {treeSet.getFirst()[0], treeSet.getLast()[0]});
        boolean shouldLook = true;
        do {
            int[] minEntry = treeSet.removeFirst();
            int listIndex = minEntry[1], nextElementIndex = minEntry[2] + 1;
            List<Integer> minEntryList = nums.get(listIndex);
            if (minEntryList.size() == nextElementIndex) {
                shouldLook = false;
            } else {
                int[] newEntry = {minEntryList.get(nextElementIndex), listIndex, nextElementIndex};
                treeSet.add(newEntry);
                curr = getMinRange(curr, new int[] {treeSet.getFirst()[0], treeSet.getLast()[0]});
            }
        } while (shouldLook);

        return curr;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(-89,1,69,89,90,98), nums2 = Arrays.asList(73,94,94,96), nums3 = Arrays.asList(11,13,76,79,90),
        nums4 = Arrays.asList(-40,-20,1,9,12,12,14), nums5 = Arrays.asList(-2,6,11,12,12,13,15);
        List<List<Integer>> nums = Arrays.asList(nums1, nums2, nums3, nums4, nums5);
        Day13SmallestRangeCoveringElementsFromKLists obj = new Day13SmallestRangeCoveringElementsFromKLists();
        System.out.println(Arrays.toString(obj.smallestRange(nums)));
    }
}
