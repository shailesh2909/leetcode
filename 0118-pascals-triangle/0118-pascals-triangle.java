class Solution {

    public static List<Integer> generateRow(int n)
    {
        List<Integer> ans = new ArrayList<>();
        int res = 1;
        ans.add(1);
        for(int i =  1; i < n; i++)
        {
            res = res*(n - i);
            res = res / i;
            
            ans.add(res);
        }

        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++)
        {
            ans.add(generateRow(i));
        }

        return ans;
    }
}