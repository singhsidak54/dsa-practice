package companies.Uber;

public class Minesweeper {
    int m, n;

    public boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }

    public boolean dfs(char[][] board, int row, int col, boolean[][] visited) {
        if(!isValid(row, col)) return false;

        if(board[row][col] == 'X') return true;
        if(board[row][col] == 'M') {
            board[row][col] = 'X';
            return true;
        }

        if(visited[row][col]) return false;
        visited[row][col] = true;
        int mines = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};
        for(int[] dir : dirs) {
            int r = row + dir[0], c = col + dir[1];
            if(isValid(r, c) && (board[r][c] == 'M' || board[r][c] == 'X')) {
                mines++;
            }
        }

        if(mines == 0) {
            board[row][col] = 'B';
            for(int[] dir : dirs) {
                int r = row + dir[0], c = col + dir[1];
                dfs(board, r, c, visited);
            }
        } else {
            board[row][col] = (char) ('0' + mines);
        }

        return false;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        dfs(board, click[0], click[1], visited);
        return board;
    }
}
