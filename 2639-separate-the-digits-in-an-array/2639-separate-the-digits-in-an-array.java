class Solution {

    String getNum(int num)
    {
        StringBuffer ans = new StringBuffer();
        while(num > 0)
        {
            int n = num % 10;
            ans.append((char) n);
            num = num / 10;
        }

        
        return ans.reverse().toString();
    }

    public int[] separateDigits(int[] nums) {
        
        String temp = "";
        for(int i = 0; i < nums.length; i++)
        {
            temp += getNum(nums[i]);

        }

        int ans[] = new int[temp.length()];

        for(int i = 0; i < temp.length(); i++)
        {
            ans[i] = temp.charAt(i);
        }

        return ans;
    }
}