package daily.jan23;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Day24SnakesAndLadders {

    public int positionToValue(int[][] board, int num) {
        int n = board.length;
        int rowFromTop = (num - 1)/n;
        int row = n - 1 - rowFromTop;
        int colFromLeft = (num - 1) % n;
        int col = rowFromTop % 2 == 0 ? colFromLeft : n - 1 - colFromLeft;

        return board[row][col];
    }
    public int snakesAndLadders(int[][] board) {
        int end = board.length * board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        queue.add(1);

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                if(curr == end) {
                    return dist;
                }

                for(int j=1; j<=6; j++) {
                    int next = curr + j;
                    if(next > end) break;

                    int nextValue = positionToValue(board, next);
                    if(nextValue > 0) {
                        next = nextValue;
                    }

                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            dist++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day24SnakesAndLadders obj = new Day24SnakesAndLadders();
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(obj.snakesAndLadders(board));
    }
}
