class Solution {
    public String removeKdigits(String num, int k) {

        if(num.length() == k)
        {
            return "0";
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++)
        {
            while(!st.isEmpty() && (st.peek() - '0') > (num.charAt(i) - '0') && k > 0)
            {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        while(k > 0 && !st.isEmpty())
        {
            st.pop();
            k--;
        }

        if(st.isEmpty())
        {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty())
        {
            res.append(st.peek());
            st.pop();
        }


        while(res.length() != 0 && res.charAt(res.length() - 1) == '0')
        {
            res.deleteCharAt(res.length() - 1);
        }
        
        res.reverse();
        if(res.length() == 0)
        {
            return "0";
        }

        return res.toString();
    }
}