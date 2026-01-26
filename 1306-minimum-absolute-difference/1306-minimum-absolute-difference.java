class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++)
        {
            int dif = arr[i+1] - arr[i];

            min = Math.min(min, dif);
        }   

        for(int i = 0; i < arr.length - 1; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();

            int dif = arr[i+1] - arr[i];

            if(dif == min)
            {
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                ans.add(temp);
            }
        }

        return ans;
    }
}