package beginner;

import java.util.Scanner;

public class FLOW001 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int t = inp.nextInt();
        while (t-- > 0) {
            int a = inp.nextInt();
            int b = inp.nextInt();
            System.out.println(a + b);
        }
    }
}
