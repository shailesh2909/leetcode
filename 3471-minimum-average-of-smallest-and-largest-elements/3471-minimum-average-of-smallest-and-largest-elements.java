class Solution {
    public double minimumAverage(int[] nums) {
        
        ArrayList<Integer> temp = new ArrayList<>();
    
        for (int num : nums) 
        {
            temp.add(num);
        }

        double ans = Double.MAX_VALUE;

        while(temp.size() != 0)
        {
            int min = Collections.min(temp);
            int max = Collections.max(temp);

            double res = (double)(min + max)/2;
            ans = Math.min(ans, res);

            System.out.println(res);

            temp.remove((Integer)min);
            temp.remove((Integer)max);
        }

        return ans;
    }
}