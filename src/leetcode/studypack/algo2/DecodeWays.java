package algo2;

public class DecodeWays {
    public static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int ways = 1;
        for(int i=0; i<s.length()-1; i++) {
            int n = Integer.parseInt(s.substring(i,i+1));
            if(n > 0 && n < 27) {
                int k = Integer.parseInt(s.substring(i, i+2));
                if(k < 27) {
                    ways++;
                }
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
    }
}
