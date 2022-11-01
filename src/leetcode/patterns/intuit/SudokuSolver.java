package patterns.intuit;

public class SudokuSolver {
    public static boolean isValidRow(char[][] board, int row, char c) {
        for(int i=0; i<9; i++) {
            if(board[row][i] == c) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidCol(char[][] board, int col, char c) {
        for(int i=0; i<9; i++) {
            if(board[i][col] == c) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidBox(char[][] board, int row, int col, char c) {
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
    public static boolean solveSudokuHelper(char[][] board, int row, int col) {
        if(row == 9) return true;
        if(col == 9) return solveSudokuHelper(board, row + 1, 0);
        if(board[row][col] != '.') return solveSudokuHelper(board, row, col + 1);

        for(char c='1'; c<='9'; c++) {
            if(isValidRow(board, row, c) && isValidCol(board, col, c) && isValidBox(board, row, col, c)) {
                board[row][col] = c;
                if(solveSudokuHelper(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        System.out.println('a');
    }
}
