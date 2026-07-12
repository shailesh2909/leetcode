class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int temp[] = new int[arr.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Arrays.sort(arr);

        int rank = 1;
        for(int i = 0; i < arr.length; i++)
        {
            
            if(i > 0 && arr[i] == arr[i - 1]) continue;

            for(int idx : map.get(arr[i]))
            {
                temp[idx] = rank;
            }
            rank++;
            
        }

        return temp;
        
    }
}