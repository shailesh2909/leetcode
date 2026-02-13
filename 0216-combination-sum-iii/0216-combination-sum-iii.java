class Solution {

    public void solve(int k, int n, int index, int sum, List<Integer> output, List<List<Integer>> res)
    {
        if(output.size() == k)
        {
            if(sum == n)
            {
                res.add(new ArrayList<>(output));
            }
            
            return;
        }

        if(index > 9 || sum > n)
        {
            return;
        }

        output.add(index);
        solve(k, n, index + 1, sum + index, output, res);
        output.remove(output.size() - 1);
        solve(k, n, index + 1, sum, output, res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<>();

        solve(k, n, 1, 0, new ArrayList<>(), res);

        return res;
    }
}