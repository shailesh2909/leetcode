/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) 
        {
            Pair p = q.poll();

            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) 
            {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }
            if (node.right != null) 
            {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) 
        {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) 
            {
                while (!pq.isEmpty()) 
                {
                    list.add(pq.poll());
                }
            }

            result.add(list);
        }

        return result;
    }

    class Pair {
        TreeNode node;
        int row, col;

        Pair(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
}