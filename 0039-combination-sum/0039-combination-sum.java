class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList(), res);
        return res;
    }

    public void backtrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> res)
    {
        if(target < 0)
        {
            return;
        }
        if(target == 0)
        {
            res.add(new ArrayList(list));
        }

        for(int i = start; i < cand.length; i++)
        {
            list.add(cand[i]);
            backtrack(cand, i, target - cand[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}