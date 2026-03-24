class Solution {
    public int coinChange(int[] arr, int T) {

        int n = arr.length;

        int[] prev = new int[T + 1];
        int[] cur = new int[T + 1];

        for (int i = 0; i <= T; i++) 
        {
            if (i % arr[0] == 0)
                prev[i] = i / arr[0];
            else
                prev[i] = (int) 1e9;
        }

        for (int ind = 1; ind < n; ind++) 
        {
            for (int target = 0; target <= T; target++) 
            {
                int notTake = prev[target];

                int take = (int) 1e9;
                if (arr[ind] <= target)
                    take = 1 + cur[target - arr[ind]];

                cur[target] = Math.min(notTake, take);
            }

            prev = cur.clone();
        }

        int ans = prev[T];
        if (ans >= 1e9)
            return -1;
        return ans;
    }
}