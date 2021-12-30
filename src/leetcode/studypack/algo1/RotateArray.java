package leetcode.studypack.algo1;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public static void rotateHelper(int[] nums, int k, boolean[] rotated, int index, int element) {
        if(rotated[index])
            return;
        int newIndex = index + k;
        if(newIndex > nums.length - 1) {
            newIndex = newIndex % nums.length;
        }
        int temp = nums[newIndex];
        nums[newIndex] = element;
        rotated[index] = true;
        rotateHelper(nums, k, rotated, newIndex, temp);
    }
    public static void rotate(int[] nums, int k) {
        if(k==0 || k == nums.length)
            return;
        boolean[] rotated = new boolean[nums.length];
        for(int i=0; i<rotated.length; i++) {
            if(!rotated[i])
                rotateHelper(nums, k, rotated, i, nums[i]);
        }
    }

    public static void reverse(int[] nums, int l, int h) {
        while (l < h) {
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;
            h--;
        }
    }

    public static void rotateBetter(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
//        rotate(a, 2);
        rotateBetter(a,2);
        System.out.println(Arrays.toString(a));
    }
}
