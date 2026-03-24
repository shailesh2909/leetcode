class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        
        int size = grid.length * grid[0].length;
        int[] arr = new int[size];
        int idx = 0;
        int MOD = 12345;

        for(int[] row : grid)
        {
            for(int val : row)
            {
                arr[idx] = val;
                idx++;
            }
        }

        long[] pref = new long[size];
        long[] suff = new long[size];
        
        pref[0] = 1;

        for(int i = 1; i < size; i++)
        {
            pref[i] = (pref[i - 1] * arr[i - 1]) % MOD;
        }

        suff[size - 1] = 1;
        for(int i = size - 2; i >= 0; i--)
        {
            suff[i] = (suff[i + 1] * arr[i + 1]) % MOD;
        }

        idx = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = (int) (pref[idx] * suff[idx]) % MOD;
                idx++;
            }
        }
        return grid;
        
    }
}