class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;

        while(left < right)
        {
            int sum = numbers[left] + numbers[right];

            if(sum == target)
            {
                int[] arr = {left + 1, right + 1};
                return arr;
            }
            else if(sum > target)
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        int[] arr = new int[0];
        return arr;

    }
}