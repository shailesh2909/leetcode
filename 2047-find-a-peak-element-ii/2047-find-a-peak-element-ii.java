class Solution {

    public static int findMaxInd(int arr[][], int col)
    {
        int maxV = -1;
        int ind = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i][col] > maxV)
            {
                maxV = arr[i][col];
                ind = i;
            }
        }

        return ind;    
    }

    public int[] findPeakGrid(int[][] mat) {
        
        int low = 0;
        int high = mat[0].length - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            int maxR = findMaxInd(mat, mid);

            int left = mid - 1 >= 0 ? mat[maxR][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[maxR][mid + 1] : -1;

            if(mat[maxR][mid] > left && mat[maxR][mid] > right)
            {
                return new int[]{maxR, mid};

            }
            else if(mat[maxR][mid] < left)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};

    }
}