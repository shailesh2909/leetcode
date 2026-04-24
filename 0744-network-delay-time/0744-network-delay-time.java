class Pair
{
    int first;
    int second;

    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] t : times) 
        {
            adj.get(t[0]).add(new Pair(t[1], t[2]));
        }

        int dist[] = new int[n + 1];

        Arrays.fill(dist, (int) 1e9);

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);

        pq.add(new Pair(k, 0));

        while(!pq.isEmpty())
        {
            Pair it = pq.peek();
            pq.remove();

            int node = it.first;
            int cost = it.second;

            for(Pair ele : adj.get(node))
            {
                int adjNode = ele.first;
                int edW = ele.second;

                if(cost + edW < dist[adjNode])
                {
                    dist[adjNode] = cost + edW;
                    pq.add(new Pair(adjNode, cost + edW));
                }
            }
        }

        int max = 0;

        for(int i = 1; i <= n; i++) 
        {
            if(dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}