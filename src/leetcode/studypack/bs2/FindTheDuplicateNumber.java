package bs2;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1, count, m;
        while (l < h) {
            count = 0;
            m = l + (h - l)/2;

            for(int num : nums) {
                if(num <= m) {
                    count++;
                }
            }

            if(count <= m) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return l;
    }

    //using floyd tortoise and hare technique
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
    }
}
