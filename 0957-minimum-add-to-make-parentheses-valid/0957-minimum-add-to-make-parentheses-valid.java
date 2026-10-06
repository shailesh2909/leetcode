class Solution {
    public int minAddToMakeValid(String s) {
        
        int ans = 0;
        //Stack<Character> st = new Stack<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                //st.push('(');
                count++;
            }
            else
            {
                if(count == 0)
                {
                    ans++;
                }
                else
                {
                    count--;
                }
            }
        }

        return ans += count;
    }
}