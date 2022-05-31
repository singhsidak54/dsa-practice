package algo2;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int arithmeticSlices = 0;

        for(int i=0; i<n-2; i++) {
            int diff = nums[i+1] - nums[i];
            for(int j=i+2; j<n; j++) {
                int cDiff = nums[j] - nums[j-1];
                if(cDiff == diff)
                    arithmeticSlices++;
                else
                    break;
            }
        }

        return arithmeticSlices;
    }

    public static int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int arithmeticSlices = 0;
        int currentAns = 0;
        int prevDiff = nums[1] - nums[0];
        for(int i=1; i<n-1; i++) {
            int diff = nums[i+1] - nums[i];
            if(diff == prevDiff) {
                currentAns++;
            } else {
                prevDiff = diff;
                currentAns = 0;
            }

            arithmeticSlices += currentAns;
        }

        return arithmeticSlices;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1,3,5,7,9}));
    }
}
