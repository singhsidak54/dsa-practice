package daily.apr23;

public class Day5MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            long avg = (long)Math.ceil(sum*1.0/(i+1));
            max = Math.max(max, avg);
        }

        return (int)max;
    }

    public static void main(String[] args) {
        Day5MinimizeMaximumOfArray obj = new Day5MinimizeMaximumOfArray();
        System.out.println(obj.minimizeArrayValue(new int[] {13,13,20,0,8,9,9}));
    }
}
