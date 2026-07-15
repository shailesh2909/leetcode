class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 1) return 0;
        
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int minIndex = 0;

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < min && i != prices.length - 1)
            {
                minIndex = i;
                min = prices[i];
                max = prices[i];
            }

            if(prices[i] > max && i > minIndex)
            {
                max = prices[i];
                ans = Math.max(ans, max - min);
            }

            
        }

        return ans < 0 ? 0 : ans;
    }
}