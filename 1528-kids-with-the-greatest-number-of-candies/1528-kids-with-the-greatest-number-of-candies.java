class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> ans = new ArrayList<>();

        int maxC = Integer.MIN_VALUE;
        
        for(int n : candies)
        {
            maxC = Math.max(maxC, n);
        }

        for(int n : candies)
        {
            if(n + extraCandies >= maxC)
            {
                ans.add(true);
            }
            else
            {
                ans.add(false);
            }
        }

        return ans;
    }
}