class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix[0].length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                sum = sum + Math.abs(matrix[i][j]);

                min = Math.min(min, Math.abs(matrix[i][j]));

                if(matrix[i][j] < 0)
                {
                    cnt++;
                }
            }
        }

        if(cnt % 2 != 0)
        {
            sum = sum - (2 * min);
            return sum;
        }

        return sum;
    }
}