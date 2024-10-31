package daily.oct24;

public class Day19FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';

        int len = 1 << n, mid = len/2;

        if(k == mid) return '1';
        if(k < mid) return findKthBit(n - 1, k);

        char toInvert = findKthBit(n - 1, len - k);
        return toInvert == '0' ? '1' : '0';
    }
}
