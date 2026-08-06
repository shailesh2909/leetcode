/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node solve(Node curr, HashMap<Node, Node> map)
    {
        if(map.containsKey(curr))
        {
            return map.get(curr);
        }

        Node clone = new Node(curr.val);
        map.put(curr, clone);

        for(Node temp : curr.neighbors)
        {
            clone.neighbors.add(solve(temp, map));
        }

        return clone;
    }
    public Node cloneGraph(Node node) {
        
        if(node == null)
        {
            return null;
        }
        
        return solve(node, new HashMap<>());
    }
}