package Scaler.SAT;

public class ImplementPowerFunction {
    public static int pow(int A, int B, int C) {
        if(B == 0) return 1;
        int currAns = A;
        boolean flag = false;
        while(B > 0) {
            currAns = (currAns * currAns) % C;
            if(B % 2 == 1) {
                flag = true;
            }
            B = B/2;
        }

        if(flag) currAns = (currAns * A) % C;
        return (C + currAns) % C;
    }

    public static void main(String[] args) {
        System.out.println(pow(-1,1,20));
    }
}
