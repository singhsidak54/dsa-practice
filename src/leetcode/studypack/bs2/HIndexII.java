package bs2;

public class HIndexII {
    public int hIndex(int[] citations) {
        int l = 0, n = citations.length, r = n, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(citations[m] < n - m) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return n - l;
    }
}
