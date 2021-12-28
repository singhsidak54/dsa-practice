package easy;

import java.util.Arrays;
import java.util.Scanner;

public class HORSES {
    static int minDiff(int [] a) {
        int ans = a[1] - a[0];
        for(int i = 1; i<a.length - 1; i++) {
            if(a[i + 1] - a[i] < ans)
                ans = a[i + 1] - a[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        while(t-- > 0) {
            int n = inp.nextInt();
            int [] a = new int[n];
            for(int i=0; i<n; i++) {
                a[i] = inp.nextInt();
            }
            Arrays.sort(a);
            System.out.println(minDiff(a));
        }
    }
}
