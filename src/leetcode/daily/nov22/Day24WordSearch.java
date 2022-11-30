package daily.nov22;

public class Day24WordSearch {
    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int index) {
        if(index == word.length()) return true;
        if(!isValid(board.length, board[0].length, row, col)) return false;
        if(board[row][col] != word.charAt(index)) return false;

        board[row][col] = '.';
        boolean ans =  dfs(board, row + 1, col, word, index + 1)
                        || dfs(board, row, col + 1, word, index + 1)
                        || dfs(board, row - 1, col, word, index + 1)
                        || dfs(board, row, col - 1, word, index + 1);

        board[row][col] = word.charAt(index);
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
