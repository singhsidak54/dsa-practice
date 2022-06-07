package algo1;

// Problem Link - https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {
    //this function is implemented in the problem already.
    boolean isBadVersion(int version) {
        return true;
    }
    public int firstBadVersion(int n) {
        int l = 1, h = n, m;
        while (l < h) {
            m = l + (h-l)/2;
            if(isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
