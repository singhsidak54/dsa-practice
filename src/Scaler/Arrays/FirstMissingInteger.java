package Scaler.Arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
    public static int firstMissingPositive(ArrayList<Integer> A) {
        for(int i=0; i<A.size(); i++) {
            int next = A.get(i);
            while(next >= 1 && next < A.size() && A.get(next - 1) != next && next != i + 1) {
                int temp = A.get(next - 1);
                A.set(next - 1, next);
                next = temp;
            }

            A.set(i, next);
        }


        for(int i=0; i<A.size(); i++) {
            if(A.get(i) != i + 1) {
                return i + 1;
            }
        }

        return A.size() + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(2);

        System.out.println(firstMissingPositive(nums));
    }
}
