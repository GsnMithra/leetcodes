// [["E","E","E","E","E","E","E","E"],
//  ["E","E","E","E","E","E","E","M"],
//  ["E","E","M","E","E","E","E","E"],
//  ["M","E","E","E","E","E","E","E"],
//  ["E","E","E","E","E","E","E","E"],
//  ["E","E","E","E","E","E","E","E"],
//  ["E","E","E","E","E","E","E","E"],
//  ["E","E","M","M","E","E","E","E"]]
// [0,0]

// [["B","B","B","B","B","B","1","E"],
//  ["B","1","1","1","B","B","1","M"],
//  ["1","E","M","1","B","B","1","1"],
//  ["M","E","1","1","B","B","B","B"],
//  ["1","1","B","B","B","B","B","B"],
//  ["B","B","B","B","B","B","B","B"],
//  ["B","1","2","2","1","B","B","B"],
//  ["B","1","M","M","1","B","B","B"]]
 
// [["B","B","B","B","B","B","1","E"],
//  ["B","1","1","1","B","B","1","M"],
//  ["1","2","M","1","B","B","1","1"],
//  ["M","2","1","1","B","B","B","B"],
//  ["1","1","B","B","B","B","B","B"],
//  ["B","B","B","B","B","B","B","B"],
//  ["B","1","2","2","1","B","B","B"],
//  ["B","1","M","M","1","B","B","B"]]

class Solution {
    public int mineCount (char [] board [], int i, int j) {
        i -= 1;
        j -= 1;
        
        int mines = 0;
        for (int c = i; c < i + 3; c += 1) {
            for (int r = j; r < j + 3; r += 1) {
                if (c >= 0 && c < board.length && r >= 0 && r < board[0].length && board[c][r] == 'M')
                    mines += 1;
            }
        }
        
        return mines;
    }
    
    public void mineSweepUtil (char [] board [], int i, int j) {
        if (Math.min (i, j) < 0 || i >= board.length || j >= board[0].length  || board[i][j] != 'E')
            return;
        
        int currMines = mineCount (board, i, j);
        if (currMines != 0)
            board[i][j] = (char) (currMines + '0');
        else {
            board[i][j] = 'B';
        
            int [] dx = new int [] { 0, 0, 1, -1, -1, 1, -1, 1 };
            int [] dy = new int [] { 1, -1, 0, 0, -1, 1, 1, -1 };

            for (int s = 0; s < 8; s += 1) {
                int newX = i + dx[s];
                int newY = j + dy[s];

                mineSweepUtil (board, newX, newY);
            }
        }
    }
    
    public char [][] updateBoard (char [] board [], int [] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        mineSweepUtil (board, click[0], click[1]);
        return board;
    }
}