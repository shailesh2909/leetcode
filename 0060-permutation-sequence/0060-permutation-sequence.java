class Solution {

    public int fact(int n)
    {
        if(n <= 1)
        {
            return 1;
        }

        return (n * fact(n - 1));
    }

    public void solve(List<Integer> nums, int k, int n, StringBuffer ans)
    {
        if(n == 0)
        {
            return;
        }

        int bs = fact(n - 1);

        int ind = k / bs;

        ans.append(nums.get(ind));

        nums.remove(ind);

        k = k % bs;

        solve(nums, k, n - 1, ans);
    }


    public String getPermutation(int n, int k) {
        
        List<Integer> nums = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            nums.add(i);
        }

        StringBuffer ans = new StringBuffer();
        solve(nums, k - 1, n, ans);

        return ans.toString();
    }
}