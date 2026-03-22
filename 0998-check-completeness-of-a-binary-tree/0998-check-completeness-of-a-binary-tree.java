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

    public int countNodes(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int ans = 1 + countNodes(root.left) + countNodes(root.right);

        return ans;
    }

    public boolean isCBT(TreeNode root, int index, int nodes)
    {
        if(root == null)
        {
            return true;
        }

        if(index >= nodes)
        {
            return false;
        }
        else
        {
            boolean left = isCBT(root.left, 2 * index + 1, nodes);
            boolean right = isCBT(root.right, 2 * index + 2, nodes);

            return (left && right);
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        
        int nodes = countNodes(root);

        return isCBT(root, 0, nodes);
    }
}