class Node
{
    public int data, row, col;

    Node(int d, int r, int c)
    {
        data = d;
        row = r;
        col = c;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int n = nums.size();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.data, b.data)
        );

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.size(); i++)
        {
            int ele = nums.get(i).get(0);
            min = Math.min(min, ele);
            max = Math.max(max, ele);

            pq.add(new Node(ele, i, 0));
        }

        int start = min, end = max;

        while(pq.size() == n)
        {
            Node temp = pq.poll();

            min = temp.data;

            if((max - min) < (end - start))
            {
                start = min;
                end = max;
            }

            if(temp.col + 1 < nums.get(temp.row).size())
            {
                max = Math.max(max, nums.get(temp.row).get(temp.col + 1));
                pq.add(new Node(nums.get(temp.row).get(temp.col + 1), temp.row, temp.col + 1)); 
            }
        }

        return new int[]{start, end};
    }
}