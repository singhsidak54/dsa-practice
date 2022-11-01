package patterns.amazon;

public class WordSearch {
    public boolean exist(char[][] board, String word, int index, int row, int col) {
        if(index == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char c = word.charAt(index);
        board[row][col] = '/';
        if(exist(board, word, index + 1, row + 1, col)) {
            board[row][col] = c;
            return true;
        }

        if(exist(board, word, index + 1, row, col + 1)) {
            board[row][col] = c;
            return true;
        }

        if(exist(board, word, index + 1, row - 1, col)) {
            board[row][col] = c;
            return true;
        }

        if(exist(board, word, index + 1, row, col - 1)) {
            board[row][col] = c;
            return true;
        }

        board[row][col] = c;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
