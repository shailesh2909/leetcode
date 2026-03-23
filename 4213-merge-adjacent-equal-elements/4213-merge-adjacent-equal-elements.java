class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        
        List<Long> ans = new ArrayList<>();
        Stack<Long> st = new Stack<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(!st.isEmpty() && st.peek().equals((long)nums[i]))
            {
                long temp = nums[i] + st.peek();
                st.pop();

                while(!st.isEmpty() && st.peek() == temp)
                {
                    temp = temp + st.peek();
                    st.pop();
                }
                st.push(temp);
            }
            else
            {
                st.push((long)nums[i]);
            }
        }

        while(!st.isEmpty())
        {
            ans.add(st.peek());
            st.pop();
        }

        Collections.reverse(ans);

        return ans;
    }
}