class Solution {

    public int[] findNSE(int[] arr)
    {
        Stack<Integer> st = new Stack<>();

        int nse[] = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }

            nse[i] = st.isEmpty() ? arr.length: st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] findPSE(int arr[])
    {
        Stack<Integer> st = new Stack<>();

        int pse[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;

        int nse[] = findNSE(arr);
        int pse[] = findPSE(arr);
        
        int MOD = 1000000007;

        int total = 0;

        for(int i = 0; i < n; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (int)((total + (long)left * right * arr[i]) % MOD);
        }

        return total;
    }
}