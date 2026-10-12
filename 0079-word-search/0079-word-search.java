class Solution {

    public boolean solve(int i, int j, int ind, char board[][], String word, boolean vis[][])
    {
        if(ind == word.length())
        {
            return true;
        }
        
        if(((i < 0 || i >= board.length) || (j < 0 || j >= board[0].length)))
        {
            return false;
        }

        if(vis[i][j] || board[i][j] != word.charAt(ind))
        {
            return false;
        }


        vis[i][j] = true;

        boolean res = solve(i + 1, j, ind + 1, board, word, vis) || solve(i - 1, j, ind + 1, board, word, vis) ||
               solve(i, j + 1, ind + 1, board, word, vis) || solve(i, j - 1, ind + 1, board, word, vis);

        vis[i][j] = false;

        return res;

    }
    public boolean exist(char[][] board, String word) {
        
        boolean vis[][] = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(solve(i, j, 0, board, word, vis))
                {
                    return true;
                }
            }
        }
        return false;
    }
}