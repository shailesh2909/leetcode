class DisjointSet
{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i = 0; i < n; i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node)
    {
        if(node == parent.get(node)) return node;

        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v)
    {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else
        {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();

        HashMap<String, Integer> map = new HashMap<>();

        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < accounts.get(i).size(); j++)
            {
                String mail = accounts.get(i).get(j);
                
                if(map.containsKey(mail) == false)
                {
                    map.put(mail, i);
                }
                else
                {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        ArrayList<String> []temp = new ArrayList[n];

        for(int i = 0; i < n; i++)
        {
            temp[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> it : map.entrySet())
        {
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            temp[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            if(temp[i].size() == 0) continue;
            Collections.sort(temp[i]);
            
            List<String> lst = new ArrayList<>();

            lst.add(accounts.get(ds.findUpar(i)).get(0));

            for(String ele : temp[i])
            {
                lst.add(ele);
            }

            ans.add(lst);
        }

        return ans;
    }
}