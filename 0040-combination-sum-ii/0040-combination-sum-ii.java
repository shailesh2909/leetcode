class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> res)
    {
        if(target == 0) 
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < cand.length; i++)
        {
            if(i > start && cand[i] == cand[i - 1])
                continue;

            if(cand[i] > target)
                break; 

            list.add(cand[i]);


            backtrack(cand, i + 1, target - cand[i], list, res);

            list.remove(list.size() - 1);
        }
    }
}
