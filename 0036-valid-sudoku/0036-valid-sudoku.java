class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9]; 

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (ch < '1' || ch > '9') return false;

                int d = ch - '1';                
                int b = (r / 3) * 3 + (c / 3);   

                if (rows[r][d] || cols[c][d] || boxes[b][d]) return false;

                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        }
        return true;
    }
}
