package Scaler.Arrays;

import java.util.ArrayList;

public class SpiralMatrixII {
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int[][] res = new int[A][A];

        int num = 1;
        int left = 0, right = A - 1, up = 0, down = A - 1;


        while(num <= A * A) {
            // go right
            int temp = left;
            while(temp <= right) {
                res[up][temp] = num;
                temp++;
                num++;
            }

            up++;
            if(up > down) {
                break;
            }

            // go down
            temp = up;
            while(temp <= down) {
                res[temp][right] = num;
                num++;
                temp++;
            }

            right--;
            if(left > right) {
                break;
            }

            // go left
            temp = right;
            while(temp >= left) {
                res[down][temp] = num;
                num++;
                temp--;
            }

            down--;
            if(up > down) {
                break;
            }

            // go up
            temp = down;
            while(temp >= up) {
                res[temp][left] = num;
                num++;
                temp--;
            }

            left++;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0; i<A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0; j<A; j++) {
                row.add(res[i][j]);
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
}
