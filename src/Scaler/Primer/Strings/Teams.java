package Scaler.Primer.Strings;

public class Teams {
    public int solve(String A) {
        int ans = 0;
        int sum = 0;
        for(char c : A.toCharArray()) {
            if(c == '0') {
                sum--;
            } else if (c == '1') {
                sum++;
            }

            if(sum == 0) ans++;
        }

        return ans;
    }
}
