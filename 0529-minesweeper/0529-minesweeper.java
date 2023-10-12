class Solution {
    public int mineCount(char[][] board, int i, int j) {
        int mines = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int newRow = i + r;
                int newCol = j + c;
                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'M') {
                    mines++;
                }
            }
        }
        return mines;
    }

    public void mineSweepUtil(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E') {
            return;
        }

        int currMines = mineCount(board, i, j);
        if (currMines != 0) {
            board[i][j] = (char) (currMines + '0');
        } else {
            board[i][j] = 'B';
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    mineSweepUtil(board, i + r, j + c);
                }
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            mineSweepUtil(board, row, col);
        }

        return board;
    }
}
