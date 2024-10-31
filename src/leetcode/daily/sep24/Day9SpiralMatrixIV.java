package daily.sep24;

import java.util.Arrays;

public class Day9SpiralMatrixIV {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(res[i], -1);
        }

        ListNode curr = head;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (curr != null) {
            // go left to right
            for(int i=left; i<=right && curr != null; i++) {
                res[top][i] = curr.val;
                curr = curr.next;
            }
            top++;

            // go top to bottom
            for(int i=top; i<=bottom && curr != null; i++) {
                res[i][right] = curr.val;
                curr = curr.next;
            }
            right--;

            // go right to left
            for(int i=right; i>=left && curr != null; i--) {
                res[bottom][i] = curr.val;
                curr = curr.next;
            }
            bottom--;

            // go bottom to top
            for(int i=bottom; i>=top && curr != null; i--) {
                res[i][left] = curr.val;
                curr = curr.next;
            }
            left++;
        }

        return res;
    }
}
