package daily.jan23.weekly;

import java.util.HashMap;

public class Week4ConfusingNumberII {

    HashMap<Integer, Integer> map;
    int count;
    public boolean isConfusing(int n) {
        int temp = n;
        int rotated = 0;
        while (temp != 0) {
            int digit = temp % 10;
            temp = temp/10;
            rotated *= 10;
            rotated += map.get(digit);
        }

        return rotated != n;
    }

    public void dfs(int N, int curr) {
        if(isConfusing(curr)) {
            count++;
        }

        for(int num : map.keySet()) {
            long next = curr * 10L + num;
            if(next <= N && next != 0) {
                dfs(N, (int) next);
            }
        }
    }

    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        count = 0;

        dfs(n, 0);
        return count;
    }

    public static void main(String[] args) {
        Week4ConfusingNumberII obj = new Week4ConfusingNumberII();
        System.out.println(obj.confusingNumberII(1000000000));
    }
}
