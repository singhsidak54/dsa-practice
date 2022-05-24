package algo2;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<cols; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if(board[rows-1][i] == 'O') {
                dfs(board, rows-1, i);
            }
        }

        for(int i=0; i<rows; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if(board[i][cols-1] == 'O') {
                dfs(board, i, cols-1);
            }
        }


        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        board[row][col] = '#';
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int[] dir : dirs) {
                int r = node[0] + dir[0];
                int c = node[1] + dir[1];
                if(r >= 0 && r < rows && c >= 0 && c < cols && board[r][c] == 'O') {
                    board[r][c] = '#';
                    queue.add(new int[] {r, c});
                }
            }
        }
    }

    public static void print(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        solve(board);
        print(board);
    }
}