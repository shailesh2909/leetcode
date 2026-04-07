class Solution {

    public void dfs(int row, int col, int[][] image, int delRow[], int delCol[], int ans[][], int color, int iniColor)
    {
        ans[row][col] = color;

        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if((nRow >= 0 && nRow < n) && (nCol >= 0 && nCol < m) && (ans[nRow][nCol] != color) && image[nRow][nCol] == iniColor)
            {
                dfs(nRow, nCol, image, delRow, delCol, ans, color, iniColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int ans[][] = image;

        int iniColor = image[sr][sc];

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        dfs(sr, sc, image, delRow, delCol, ans, color, iniColor);

        return ans;
    }
}