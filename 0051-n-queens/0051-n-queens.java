class Solution {
    List <List <String>> boards;
    public boolean validQueen (List <String> board, int i, int j) {
        int idx = i - 1;
        while (idx >= 0) {
            if (board.get (idx).substring (j, j + 1).equals ("Q"))
                return false;
            idx -= 1;
        }
        
        int di = i - 1, dj = j - 1;
        while (di >= 0 && dj >= 0) {
            if (board.get (di).substring (dj, dj + 1).equals ("Q"))
                return false;
            di -= 1;
            dj -= 1;
        }
        
        di = i - 1;
        dj = j + 1;
        while (di >= 0 && dj < board.size ()) {
            if (board.get (di).substring (dj, dj + 1).equals ("Q"))
                return false;
            di -= 1;
            dj += 1;
        }
        
        return true;
    }
    
    public boolean solveQueensUtil (List <String> board, int i, int N) {
        if (i == N) {
            List <String> resultBoard = new ArrayList <>();
            for (String s : board)
                resultBoard.add (s);

            this.boards.add (resultBoard);
            return false;
        }
        
        for (int s = 0; s < N; s += 1) {
            if (validQueen (board, i, s)) {
                board.set (i, board.get (i).substring (0, s) + "Q" + board.get (i).substring (s + 1));
                if (solveQueensUtil (board, i + 1, N))
                    return true;
                board.set (i, board.get (i).substring (0, s) + "." + board.get (i).substring (s + 1));
            }
        }
        
        return false;
    }
    
    public List <List <String>> solveNQueens (int N) {
        this.boards = new ArrayList <>();
        List <String> board = new ArrayList <>(N);
        for (int i = 0; i < N; i += 1) {
            board.add ("");
            for (int j = 0; j < N; j += 1)
                board.set (i, board.get (i) + ".");
        }
        
        solveQueensUtil (board, 0, N);
        return this.boards;
    }
}