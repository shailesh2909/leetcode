/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    void markParents(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode target)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();

            if(curr.left != null)
            {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right != null)
            {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(currLevel == k)
            {
                break;
            }
            currLevel++;

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null)
                {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null)
                {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null)
                {
                    queue.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            list.add(curr.val);
        }

        return list;
    }
}