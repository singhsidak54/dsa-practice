package daily.nov22;

public class Day7Maximum69Number {
    boolean changed = false;
    int ans = 0;
    public void maximum69NumberHelper (int num, int pow) {
        if(num == 0) return;
        maximum69NumberHelper(num/10, pow * 10);

        int digit = num % 10;
        if(!changed && digit == 6) {
            digit = 9;
            changed = true;
        }
        ans += digit * pow;
    }

    public int maximum69Number (int num) {
        maximum69NumberHelper(num, 1);
        return ans;
    }
}
