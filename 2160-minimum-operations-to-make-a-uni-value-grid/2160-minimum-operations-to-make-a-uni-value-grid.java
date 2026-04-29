class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int[] temp = new int[grid.length * grid[0].length];

        int idx = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                temp[idx++] = grid[i][j];
            }
        }

        Arrays.sort(temp);
        
        int ans = 0;

        int mid = temp[temp.length / 2];

        for(int i = 0; i < temp.length; i++)
        {
               int steps = Math.abs(temp[i] - mid); 

               if(steps % x != 0)
               {
                    return -1;
               }
               else
               {
                    ans += steps / x;
               }
        }

        return ans;
    }
}