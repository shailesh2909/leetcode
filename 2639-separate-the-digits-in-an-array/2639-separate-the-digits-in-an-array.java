class Solution {
    public int[] separateDigits(int[] nums) {
        
        StringBuilder temp = new StringBuilder();
        for (int num : nums) 
        {
            temp.append(num);
        }

        int[] ans = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) 
        {
            ans[i] = temp.charAt(i) - '0';
        }

        return ans;
    }
}