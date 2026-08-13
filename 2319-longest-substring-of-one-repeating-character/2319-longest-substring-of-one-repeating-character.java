class Solution {

    class Node
    {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node() {}

        Node(char c)
        {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            len = 1;
        }
    }

    Node tree[];
    char arr[];

    public void build(int node, int l, int r)
    {
        if(l == r)
        {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public Node merge(Node left, Node right)
    {
        Node res = new Node();

        res.len = left.len + right.len;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.prefix = left.prefix;
        res.suffix = right.suffix;

        res.best = Math.max(left.best, right.best);

        if(left.rightChar == right.leftChar)
        {
            if(left.prefix == left.len)
            {
                res.prefix = left.len + right.prefix;
            }

            if(right.suffix == right.len)
            {
                res.suffix = right.len + left.suffix;
            }

            res.best = Math.max(
                res.best,
                left.suffix + right.prefix
            );
        }

        return res;
    }

    public void update(int node, int l, int r, int index, char c)
    {
        if(l == r)
        {
            arr[index] = c;
            tree[node] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if(index <= mid)
        {
            update(2 * node, l, mid, index, c);
        }
        else
        {
            update(2 * node + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices)
    {
        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int ans[] = new int[k];

        for(int i = 0; i < k; i++)
        {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}