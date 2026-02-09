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
    public void inorder(TreeNode node, ArrayList<Integer> res)
    {
        if(node == null)
        {
            return;
        }

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
    public int minDiffInBST(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        inorder(root, res);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < res.size() - 1; i++)
        {
            if((res.get(i + 1) - res.get(i)) < min)
            {
                min = res.get(i + 1) - res.get(i);
            }
            System.out.println(min);
        } 

        return min;    
    }
}