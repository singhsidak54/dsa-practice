package Scaler.BitManipulation;

public class SingleNumberIII {
    public int[] solve(int[] A) {
        int xor = 0;
        for(int num : A) {
            xor = xor ^ num;
        }

        int i = 0;
        while (((xor >> i) & 1) == 0) {
            i++;
        }

        int num1 = 0, num2 = 0;

        for(int num : A) {
            if(((num >> i) & 1) == 1) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }

        if(num1 > num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        return new int[] {num1, num2};
    }
}
