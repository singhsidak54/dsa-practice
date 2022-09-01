package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    public static boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int firstJump = curr + arr[curr], secondJump = curr - arr[curr];
            if(firstJump >= 0 && firstJump < n && arr[firstJump] != -1) {
                if(arr[firstJump] == 0) {
                    return true;
                }
                queue.add(firstJump);
            }

            if(secondJump >= 0 && secondJump < n && arr[secondJump] != -1) {
                if(arr[secondJump] == 0) {
                    return true;
                }
                queue.add(secondJump);
            }
            arr[curr] = -1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[] {3,0,2,1,2}, 2));
    }
}
