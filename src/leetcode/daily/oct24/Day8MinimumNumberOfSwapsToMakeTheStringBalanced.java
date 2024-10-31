package daily.oct24;

public class Day8MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        int n = s.length();
        int nOpen = 0, nBackOpen = 0, swaps = 0, l = 0, r = n - 1;
        while (l <= r) {
            if (nOpen >= 0) {
                char c = s.charAt(l);
                if (c == '[') nOpen++;
                else if (c == ']') nOpen--;
                l++;
            } else {
                while (nBackOpen <= 0) {
                    char d = s.charAt(r);
                    if (d == '[') nBackOpen++;
                    else if (d == ']') nBackOpen--;
                    r--;
                }

                // swap r + 1 with l - 1
                nOpen += 2;
                swaps++;
            }
        }

        return swaps;
    }
}
