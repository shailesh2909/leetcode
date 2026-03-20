class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length;
        
        int[][] ans = new int[row - k + 1][col - k + 1];

        for(int i = 0; i <= row - k; i++)
        {
            for(int j = 0; j <= col - k; j++)
            {
                int idx = 0;
                int[] temp = new int[k*k];
                for (int r = 0; r < k; r++) 
                {
                    for (int c = 0; c < k; c++) 
                    {
                        temp[idx++] = grid[i + r][j + c];
                    }
                }

                if(k == 1)
                {
                    ans[i][j] = 0;
                    continue;
                }

                Arrays.sort(temp);
                int min = Integer.MAX_VALUE;
                for(int s = 0; s < temp.length - 1; s++)
                {
                    if(temp[s] != temp[s + 1])
                        min = Math.min(min, Math.abs(temp[s] - temp[s + 1]));
                }

                if(min == Integer.MAX_VALUE) 
                {
                    min = 0;
                }

                ans[i][j] = min;
            }
        }

        return ans;
    }
}