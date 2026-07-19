class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] arr = new int[26];
        boolean vis[] = new boolean[26];

        for(int i = 0; i < s.length(); i++)
        {
            arr[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(vis[ch - 'a'])
            {
                continue;
            }

            while(!st.isEmpty() && st.peek() > ch && arr[st.peek() - 'a'] > i)
            {
                vis[st.pop() - 'a'] = false;
            }

            st.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder str = new StringBuilder();
        
        for(char ch : st)
        {
            str.append(ch);
        }

        return str.toString();
    }
}