package daily.apr23;

import java.util.Arrays;
import java.util.TreeSet;

public class Day25SmallestNumberInInfiniteSet {

    boolean[] nums;
    public Day25SmallestNumberInInfiniteSet() {
        nums = new boolean[1001];
        Arrays.fill(nums, true);
    }

    public int popSmallest() {
        for(int i=1; i<1001; i++) {
            if(nums[i]) {
                nums[i] = false;
                return i;
            }
        }

        return -1;
    }

    public void addBack(int num) {
        nums[num] = true;
    }
}
