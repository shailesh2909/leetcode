class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i++)
        {
            ans.add(generateRow(i));
        }

        return ans;
    }

    public List<Integer> generateRow(int n)
    {
        List<Integer> ans = new ArrayList<>();

        int val = 1;
        ans.add(val);

        for(int i = 1; i < n; i++)
        {
            val = val * (n - i) / i;
            ans.add(val);
        }

        return ans;
    }
}