package ps1;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i=2; i<arr.length; i++) {
            if(arr[i] - arr[i-1] != diff) {
                return false;
            }
        }

        return true;
    }

    public boolean canMakeArithmeticProgression2(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = arr.length;
        for(int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        if((max - min) % (n - 1) != 0) {
            return false;
        }

        int diff = (max - min)/(n-1);
        int i = 0;
        while (i < n) {
            if(arr[i] == min + diff * i) {
                i++;
                continue;
            }

            int dis = arr[i] - min;
            if(dis % diff != 0) return false;

            int pos = (dis)/diff;
            if(arr[pos] == arr[i]) return false;
            int temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }

        return true;
    }
}
