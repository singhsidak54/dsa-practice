package misc;

import java.util.Arrays;

public class JumpGameV {
    static int[] dp;
    static int dT;
    public static int jumps(int[] arr, int index) {
        if(index < 0 || index > arr.length) return 0;
        if(dp[index] != -1) return dp[index];

        int currJumps = 0;

        // positive jumps
        int currIndex = index, t = dT;
        while (currIndex < arr.length && t > 0) {
            currIndex++;
            t--;
            if(currIndex < arr.length && arr[currIndex] < arr[index]) {
                currJumps = Math.max(currJumps, 1 + jumps(arr, currIndex));
            } else {
                break;
            }
        }

        currIndex = index;
        t = dT;
        //negative jumps
        while (currIndex > 0 && t > 0) {
            currIndex--;
            t--;
            if(arr[currIndex] < arr[index]) {
                currJumps = Math.max(currJumps, 1 + jumps(arr, currIndex));
            } else {
                break;
            }
        }

        dp[index] = currJumps;
        return dp[index];
    }

    public static int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        dT = d;
        Arrays.fill(dp, -1);
        int maxJumps = 0;
        for(int i=0; i<arr.length; i++) {
            maxJumps = Math.max(maxJumps, jumps(arr, i));
        }

        return maxJumps + 1;
    }

    public static void main(String[] args) {
        int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
        System.out.println(maxJumps(arr, 2));
    }
}
