class Node
{
    Node arr[] = new Node[2];

    public boolean containsKey(int bit)
    {
        return (arr[bit] != null);
    }

    public Node get(int bit)
    {
        return arr[bit];
    }

    public void put(int bit, Node node)
    {
        arr[bit] = node;
    }
}

class Trie
{
    Node root;

    public Trie()
    {
        root = new Node();
    }

    public void insert(int num)
    {
        Node node = root;
        for(int i = 31; i >= 0; i--)
        {
            int bit = (num >> i) & 1;

            if(!node.containsKey(bit))
            {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public int getMax(int num)
    {
        Node node = root;
        int max = 0;

        for(int i = 31; i >= 0; i--)
        {
            int bit = (num >> i) & 1;

            if(node.containsKey(1 - bit))
            {
                max = max | (1 << i);
                node = node.get(1 - bit);
            }
            else
            {
                node = node.get(bit);
            }
        }

        return  max;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        
        Trie trie = new Trie();

        for(int i = 0; i < nums.length; i++)
        {
            trie.insert(nums[i]);
        }

        int max = 0;

        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(max, trie.getMax(nums[i]));
        }

        return max;
    }
}