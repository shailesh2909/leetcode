class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        
        for(int i = 0; i < asteroids.length; i++)
        {
            boolean destroyed = false;
            while(!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0)
            {
                if(Math.abs(st.peek()) < Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                else if(Math.abs(st.peek()) == Math.abs(asteroids[i]))
                {
                    destroyed = true;
                    st.pop();
                    break;
                }
                else if(st.peek() > Math.abs(asteroids[i]))
                {
                    destroyed = true;
                    break;
                }
                
            }

            if(!destroyed)
                st.push(asteroids[i]);
            
        }

        int[] arr = new int[st.size()];

        System.out.println(st.size());
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            arr[i] = st.pop();
        }

        return arr;
    }
}