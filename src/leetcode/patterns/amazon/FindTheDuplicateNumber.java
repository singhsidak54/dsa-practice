package patterns.amazon;

public class FindTheDuplicateNumber {
    public int findDuplicateBS(int[] nums) {
        int l = 1, r = nums.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            int count = 0;
            for(int num : nums) {
                if(num <= m) {
                    count++;
                }
            }

            if(count <= m) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int findDuplicateTwoPointer(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
