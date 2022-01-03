package leetcode.studypack.ds1;

import java.util.HashSet;

// Problem Link - https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public static boolean isColValid(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(set.contains(board[i][col]))
                return false;

            if(board[i][col] != '.')
                set.add(board[i][col]);
        }
        return true;
    }

    public static boolean isRowValid(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(set.contains(board[row][i]))
                return false;

            if(board[row][i] != '.')
                set.add(board[row][i]);
        }
        return true;
    }

    public static boolean isBoxValid(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for(int i=row-2; i<=row; i++) {
            for(int j=col-2; j<=col; j++) {
                if(set.contains(board[i][j]))
                    return false;

                if(board[i][j] != '.')
                    set.add(board[i][j]);
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            if(!isRowValid(board, i))
                return false;
            for(int j=0; j<9; j++) {
                if(!isColValid(board, j))
                    return false;

                if((j + 1) % 3 == 0 && (i + 1) % 3 == 0){
                    if(!isBoxValid(board, i, j))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }
}
