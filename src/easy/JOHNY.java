package easy;

import java.util.Scanner;

public class JOHNY {
    static int countLesser(int [] a, int key) {
        int lesser = 1; //starting from 1 because the problem is in 1-indexing
        for(int currSong : a) {
            if(currSong < key)
                lesser++;
        }
        return lesser;
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
            int k = inp.nextInt();
            int favSong = a[k - 1];
            System.out.println(countLesser(a, favSong));
        }
    }
}
