package daily.jan23;

public class Day17FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int ans = 0, ones = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                ans = Math.min(ones, ans + 1);
            } else {
                ones++;
            }
        }

        return ans;
    }
}
