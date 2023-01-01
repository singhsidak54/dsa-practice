package misc;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length) return false;
        if(arr[start] == -1) return false;
        if(arr[start] == 0) return true;

        int jump = arr[start];
        arr[start] = -1;
        return canReach(arr, start + jump) || canReach(arr, start - jump);
    }
}
