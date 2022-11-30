package daily.nov22;

public class Day8MakeTheStringGreat {
    public static boolean isNotGreat(StringBuilder s, int i) {
        return Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32;
    }

    public static String makeGood(String s) {
        StringBuilder ans = new StringBuilder(s);
        int i = s.length() - 2;
        while (i >= 0) {
            if(i != ans.length() - 1 && isNotGreat(ans, i)) {
                ans.deleteCharAt(i + 1);
                ans.deleteCharAt(i);
            }
            i--;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("sS"));
    }
}
