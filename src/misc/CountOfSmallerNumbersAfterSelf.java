package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static int insertElementInSortedList(List<Integer> sortedList, int num) {
        int l = 0, r = sortedList.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(sortedList.get(m) < num) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        sortedList.add(l, num);
        return l;
    }

    public static void reverse(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int temp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, temp);

            l++;
            r--;
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> result = new ArrayList<>(nums.length);
        for(int i=nums.length-1; i>=0; i--) {
            result.add(insertElementInSortedList(sortedList, nums[i]));
        }

        reverse(result);
        return result;
    }

    private static class Node {
        int num;
        int originalIdx;
        Node(int num, int originalIdx) {
            this.num = num;
            this.originalIdx = originalIdx;
        }
    }

    public static void countSmallerHelper(Node[] nums, int left, int right, int[] result) {
        if(left >= right) return;

        int mid = left + (right - left)/2;
        countSmallerHelper(nums, left, mid, result);
        countSmallerHelper(nums, mid + 1, right, result);

        List<Node> merged = new ArrayList<>();
        int leftPtr = left, rightPtr = mid + 1;
        int numSmallerAfter = 0;
        while (leftPtr <= mid && rightPtr <= right) {
            if(nums[leftPtr].num > nums[rightPtr].num) {
                numSmallerAfter++;
                merged.add(nums[rightPtr]);
                rightPtr++;
            } else {
                result[nums[leftPtr].originalIdx] += numSmallerAfter;
                merged.add(nums[leftPtr]);
                leftPtr++;
            }
        }

        while (leftPtr <= mid) {
            merged.add(nums[leftPtr]);
            result[nums[leftPtr].originalIdx] += numSmallerAfter;
            leftPtr++;
        }

        while (rightPtr <= right) {
            merged.add(nums[rightPtr]);
            rightPtr++;
        }

        int position = left;
        for(Node node : merged) {
            nums[position++] = node;
        }
    }

    public static List<Integer> countSmallerMergeSort(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for(int i=0; i<nodes.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }

        int[] result = new int[nums.length];
        countSmallerHelper(nodes, 0, nodes.length - 1, result);

        List<Integer> ans = new ArrayList<>();
        for(int count : result) {
            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSmallerMergeSort(new int[] {5, 2, 6, 1}));
    }
}
