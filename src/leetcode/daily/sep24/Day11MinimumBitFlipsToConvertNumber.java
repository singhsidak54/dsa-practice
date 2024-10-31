package daily.sep24;

public class Day11MinimumBitFlipsToConvertNumber {
    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            int bit = n & 1;
            if(bit == 1) count++;
            n = n >> 1;
        }
        return count;
    }

    public int minBitFlips(int start, int goal) {
        int diffBits = 0;
        while (start != 0 && goal != 0) {
            int startBit = start & 1, goalBit = goal & 1;
            if(startBit != goalBit) diffBits++;
            start >>= 1;
            goal >>= 1;
        }

        int ans = diffBits;
        if(start != 0) ans += countSetBits(start);
        if(goal != 0) ans += countSetBits(goal);

        return ans;
    }

    public int minBitFlipsAlt(int start, int goal) {
        int ans = 0, xorResult = start ^ goal;
        // count number of set bits in xorResult
        while (xorResult > 0) {
            // Brian Kernighan’s Algorithm used to count number of set bits
            xorResult = xorResult & (xorResult - 1);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day11MinimumBitFlipsToConvertNumber obj = new Day11MinimumBitFlipsToConvertNumber();
        System.out.println(obj.minBitFlipsAlt(10, 7));
    }
}
