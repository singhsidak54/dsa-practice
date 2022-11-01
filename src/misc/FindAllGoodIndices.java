package misc;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(2 * k >= nums.length) return res;

        int beforeWindowStart = 0, beforeWindowEnd = k - 1, afterWindowStart = k + 1, afterWindowEnd = k + k;
        int beforeCount = 0, afterCount = 0;
        for(int i=beforeWindowStart+1; i<=beforeWindowEnd; i++) {
            //keep track of number of indices which do not satisfy before condition i.e. must be non-increasing
            if(nums[i] > nums[i - 1]) {
                beforeCount++;
            }
        }

        for(int i=afterWindowStart+1; i<=afterWindowEnd; i++) {
            //keep track of number of indices which do not satisfy after condition i.e. must be non-decreasing
            if(nums[i] < nums[i-1]) {
                afterCount++;
            }
        }

        int curr = k;
        while (curr < nums.length - k) {
            // count = 0 means all elements in the respective windows meet the requirement
            if(beforeCount == 0 && afterCount == 0) {
                res.add(curr);
            }

            if(curr == nums.length - k - 1) {
                break;
            }

            /*
                Update before window.
                If element being deleted from window didn't satisfy before condition decrement beforeCount.
                If element being added to the window doesn't satisfy before condition increment beforeCount.
             */
            if(nums[beforeWindowStart + 1] > nums[beforeWindowStart]) {
                beforeCount--;
            }
            beforeWindowStart++;

            if(nums[beforeWindowEnd + 1] > nums[beforeWindowEnd]) {
                beforeCount++;
            }
            beforeWindowEnd++;


            /*
                Update after window.
                If element being deleted from window didn't satisfy after condition decrement afterCount.
                If element being added to the window doesn't satisfy after condition increment afterCount.
             */
            if(nums[afterWindowStart + 1] < nums[afterWindowStart]) {
                afterCount--;
            }
            afterWindowStart++;

            if(nums[afterWindowEnd + 1] < nums[afterWindowEnd]) {
                afterCount++;
            }
            afterWindowEnd++;

            curr++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {878724,201541,179099,98437,35765,327555,475851,598885,849470,943442};
        System.out.println(goodIndices(nums, 4));
    }
}
