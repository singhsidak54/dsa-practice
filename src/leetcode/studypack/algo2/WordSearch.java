package algo2;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == wordArray[0] && exist(board, i, j, wordArray, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int row, int col, char[] wordArray, int index) {
        if(index == wordArray.length) {
            return true;
        } else if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        } else if (board[row][col] != wordArray[index]) {
            return false;
        } else {
            char temp = board[row][col];
            board[row][col] = '*';
            if(exist(board, row + 1, col, wordArray, index + 1)
                || exist(board, row - 1, col, wordArray, index + 1)
                || exist(board, row, col + 1, wordArray, index + 1)
                || exist(board, row, col - 1, wordArray, index + 1)) {
                return true;
            }
            board[row][col] = temp;
            return false;
        }
    }
}
