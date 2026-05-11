class Solution {

    List<Integer> getNum(int num)
    {
        List<Integer> arr = new ArrayList<>();
        while(num > 0)
        {
            int n = num % 10;
            arr.add(n);
            num = num / 10;
        }

        Collections.reverse(arr);

        return arr;
    }

    public int[] separateDigits(int[] nums) {
        
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            List<Integer> temp = getNum(nums[i]);

            for(int j = 0; j < temp.size(); j++)
            {
                arr.add(temp.get(j));
            }
        }

        int ans[] = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++)
        {
            ans[i] = arr.get(i);
        }

        return ans;
    }
}