package companies.Bloomberg;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        boolean todo = false;
        int R = board.length, C = board[0].length;

        // horizontal direction
        for(int r=0; r<R; r++) {
            for(int c=0; c+2<C; c++) {
                int candy = Math.abs(board[r][c]);
                if(candy != 0 && candy == Math.abs(board[r][c + 1]) && candy == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -candy;
                    todo = true;
                }
            }
        }

        // vertical direction
        for(int r=0; r+2<R; r++) {
            for(int c=0; c<C; c++) {
                int candy = Math.abs(board[r][c]);
                if(candy != 0 && candy == Math.abs(board[r + 1][c]) && candy == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -candy;
                    todo = true;
                }
            }
        }


        for(int c=0; c<C; c++) {
            int wPointer = R - 1;
            for(int rPointer=R-1; rPointer>=0; rPointer--) {
                if(board[rPointer][c] > 0) {
                    board[wPointer--][c] = board[rPointer][c];
                }
            }

            while (wPointer >= 0) {
                board[wPointer--][c] = 0;
            }
        }

        return todo ? candyCrush(board) : board;
    }
}
