package easy;

import java.util.Scanner;

public class EVENGAME {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        while(t-- > 0) {
            int n = inp.nextInt();
            int sum = 0;
            while(n-- > 0) {
                sum += inp.nextInt();
            }
            if(sum % 2 == 0)
                System.out.println(1);
            else
                System.out.println(2);
        }
    }
}
