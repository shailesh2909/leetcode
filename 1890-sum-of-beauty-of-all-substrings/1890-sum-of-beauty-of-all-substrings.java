class Solution {
    public int beautySum(String s) {

        int total = 0;
        
        for(int j = 0; j < s.length(); j++)
        {
            int arr[] = new int[26];

            for(int i = j; i < s.length(); i++)
            {
                char ch = s.charAt(i);
                arr[ch-'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k = 0; k < arr.length; k++)
                {
                    if(arr[k] > 0)
                    {
                        min = Math.min(min, arr[k]);
                        max = Math.max(max, arr[k]);
                    }
                
            }

            total += (max - min);
            }

            
        }

        return total;
    }

    
}