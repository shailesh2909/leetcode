class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }

                char temp = st.pop();

                if(ch == ')' && temp != '(')
                {
                    return false;
                }

                if(ch == ']' && temp != '[')
                {
                    return false;
                }

                if(ch == '}' && temp != '{')
                {
                    return false;
                }
            } 

        }

        return st.isEmpty();
        
    }
}