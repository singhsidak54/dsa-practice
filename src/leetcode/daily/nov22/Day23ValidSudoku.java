package daily.nov22;

import java.util.HashSet;
import java.util.Set;

public class Day23ValidSudoku {
    public boolean isRowValid(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[row][i] == '.') continue;
            if(set.contains(board[row][i])) {
                return false;
            } else {
                set.add(board[row][i]);
            }
        }
        return true;
    }

    public boolean isColValid(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[i][col] == '.') continue;
            if(set.contains(board[i][col])) {
                return false;
            } else {
                set.add(board[i][col]);
            }
        }
        return true;
    }

    public boolean isBoxValid(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[row+i][col+j] == '.') continue;
                if(set.contains(board[row+i][col+j])) {
                    return false;
                } else {
                    set.add(board[row+i][col+j]);
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            if(!isRowValid(board, i)) {
                return false;
            }

            if(!isColValid(board, i)) {
                return false;
            }
        }

        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                if(!isBoxValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
