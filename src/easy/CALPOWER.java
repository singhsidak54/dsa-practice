package easy;

import java.util.Arrays;
import java.util.Scanner;

public class CALPOWER {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        while(t-- > 0) {
            String name = inp.next();
            char [] temp = name.toCharArray();
            Arrays.sort(temp);
            int power = 0;
            for(int i=0; i<temp.length; i++) {
                power += (i+1) * (temp[i] - 'a' + 1);
            }
            System.out.println(power);
        }
    }
}
