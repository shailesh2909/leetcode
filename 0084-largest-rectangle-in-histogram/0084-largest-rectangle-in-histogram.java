class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stk = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i < n; i++)
        {
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i])
            {
                int ele = stk.peek();
                stk.pop();
                int nse = i;
                int pse = stk.isEmpty() ? -1 : stk.peek();

                maxArea = Math.max(maxArea, heights[ele] * (nse - pse - 1));
            }

            stk.push(i);
        }

        while(!stk.isEmpty())
        {
            int nse = n;
            int ele = stk.pop(); 
            int pse = stk.isEmpty() ? -1 : stk.peek();
            maxArea = Math.max(maxArea, heights[ele] * (nse - pse - 1));
        }

        return maxArea;
    }
}