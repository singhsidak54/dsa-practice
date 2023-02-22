package daily.feb23;

public class Day1GreatestCommonDivisorOfStrings {

    public String joinWords(String str, int k) {
        return str.repeat(k);
    }

    public boolean isValid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if(len1 % k > 0 || len2 % k > 0) {
            return false;
        }

        String base = str1.substring(0, k);
        int n1 = len1/k, n2 = len2/k;

        return str1.equals(joinWords(base, n1)) && str2.equals(joinWords(base, n2));
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for(int i=Math.min(len1, len2); i>=0; i--) {
            if(isValid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }

    public int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
    public String gcdOfStringsMaths(String str1, String str2) {
        String s1 = str1 + str2, s2 = str2 + str1;
        if(!s1.equals(s2)) {
            return "";
        }

        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
}
