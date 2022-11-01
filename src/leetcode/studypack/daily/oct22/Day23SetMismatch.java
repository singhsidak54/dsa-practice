package daily.oct22;


public class Day23SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] done = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++) {
            done[nums[i]]++;
        }

        int duplicate = -1, lost = -1;
        for(int i=1; i<=nums.length; i++) {
            if(done[i] == 2) {
                duplicate = i;
            } else if (done[i] == 0) {
                lost = i;
            }

            if(duplicate != -1 && lost != -1) {
                return new int[] { duplicate, lost };
            }
        }
        return new int[] {-1};
    }

    public int[] findErrorNums2(int[] nums) {
        int duplicate = - 1, lost = -1;

        for(int i=0; i<nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr - 1] < 0) {
                duplicate = curr;
            } else {
                nums[curr - 1] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                lost = i + 1;
                break;
            }
        }

        return new int[] { duplicate, lost };
    }
}
