package lc75l2;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int k = nums.length - 1, closestSum = Integer.MAX_VALUE;

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<k; j++) {
                while (k > j + 1 && nums[k] + nums[i] + nums[j] > target) {
                    k--;
                }
                int currClosesSum = nums[i] + nums[k] + nums[j];
                if(k != nums.length - 1) {
                    if(Math.abs(nums[i] + nums[j] + nums[k+1] - target) < Math.abs(target - currClosesSum)) {
                        currClosesSum = nums[i] + nums[j] + nums[k+1];
                    }
                }

                if(currClosesSum == target) return currClosesSum;

                if(Math.abs(target - currClosesSum) < Math.abs(target - closestSum)) {
                    closestSum = currClosesSum;
                }
                System.out.println(closestSum);
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}
