package misc;

public class SudokuSolver {
    public boolean isValidRow(char[][] board, int row, char c) {
        for(int i=0; i<board[row].length; i++) {
            if(board[row][i] == c) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidCol(char[][] board, int col, char c) {
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == c) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidBox(char[][] board, int row, int col, char c) {
        row = 3 * (row / 3);
        col = 3 * (col / 3);
        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                if(board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudokuHelper(char[][] board, int row, int col) {
        if(row == 9) return true;
        if(col == 9) return solveSudokuHelper(board, row + 1, 0);
        if(board[row][col] != '.') return solveSudokuHelper(board, row, col + 1);

        for(char i='1'; i<='9'; i++) {
            if(isValidRow(board, row, i) && isValidCol(board, col, i) && isValidBox(board, row, col, i)) {
                board[row][col] = i;
                if(solveSudokuHelper(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }
}
