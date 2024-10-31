package daily.oct24;

public class Day30MinimumNumberOfRemovalsToMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] toRemoveFromLeft = new int[n], toRemoveFromRight = new int[n];

        for(int i=1; i<n; i++) {
            toRemoveFromLeft[i] = i;
            for(int j=0; j<i; j++) {
                if(nums[j] >= nums[i]) continue;
                toRemoveFromLeft[i] = Math.min(toRemoveFromLeft[i], toRemoveFromLeft[j] + (i - j - 1));
            }
        }


        for(int i=n-2; i>=0; i--) {
            toRemoveFromRight[i] = n - i - 1;
            for(int j=i+1; j<n; j++) {
                if(nums[j] >= nums[i]) continue;
                toRemoveFromRight[i] = Math.min(toRemoveFromRight[i], toRemoveFromRight[j] + (j - i - 1));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<n-1; i++) {
            if(toRemoveFromLeft[i] == i) continue;
            if(toRemoveFromRight[i] == (n - i - 1)) continue;
            ans = Math.min(ans, toRemoveFromLeft[i] + toRemoveFromRight[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day30MinimumNumberOfRemovalsToMakeMountainArray obj = new Day30MinimumNumberOfRemovalsToMakeMountainArray();
        int[] arr = {100,92,89,77,74,66,64,66,64};
        System.out.println(obj.minimumMountainRemovals(arr));
    }
}
