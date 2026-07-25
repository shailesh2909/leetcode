class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0)
        {
            return 0;
        }

        if(s.length() == 1)
        {
            return 1;
        }

        HashMap<Character, Boolean> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), false);
        }

        int ans = Integer.MIN_VALUE;

        int right = 0;
        int left = 0;
        while(right < s.length())
        {
            if(map.get(s.charAt(right)) == false)
            {
                map.put(s.charAt(right), true);
                right++;
            }
            else
            {
                ans = Math.max(ans, right - left);
                map.put(s.charAt(left), false);
                left++;
            }
        }

        ans = Math.max(ans, right - left);
        return ans;
    }
}
