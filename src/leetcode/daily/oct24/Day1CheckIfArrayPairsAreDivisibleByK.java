package daily.oct24;

public class Day1CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCounts = new int[k];
        for(int num : arr) {
            int rem = ((num % k) + k) % k;
            remainderCounts[rem]++;
        }

        int l = 1, r = k - 1;
        while (l < r) {
            int lCount = remainderCounts[l], rCount = remainderCounts[r];
            if(lCount != rCount) return false;
            l++;
            r--;
        }

        return k % 2 != 0 || remainderCounts[k / 2] % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,-2,2,-3,3,-4,3};
        Day1CheckIfArrayPairsAreDivisibleByK obj = new Day1CheckIfArrayPairsAreDivisibleByK();
        System.out.println(obj.canArrange(arr, 3));
    }
}
