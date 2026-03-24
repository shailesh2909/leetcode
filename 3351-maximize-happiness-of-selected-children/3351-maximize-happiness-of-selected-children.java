class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness);

        for (int i = 0; i < happiness.length / 2; i++) 
        {
            int temp = happiness[i];
            happiness[i] = happiness[happiness.length - 1 - i];
            happiness[happiness.length - 1 - i] = temp;
        }   

        long ans = 0;
        if(k == 1)
        {
            return (long)happiness[0];
        }

        for(int i = 0; i < k; i++)
        {   
            int curr = happiness[i] - i;
            if(curr > 0)
                ans += curr;
            else
                break;
        }

        return ans;
    }
}