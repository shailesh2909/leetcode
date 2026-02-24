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
    public static void find(TreeNode root, StringBuilder output, List<String> res)
    {
        if(root == null)
        {
            return;
        }
        output.append(Integer.toString(root.val));
        if(root.left == null && root.right == null)
        {
            res.add(output.toString());
        }
        else
        {
            find(root.left, output, res);
            find(root.right, output, res);
        }
        
        
        output.deleteCharAt(output.length() - 1);

       
    }
    public int sumRootToLeaf(TreeNode root) {
        
        List<String> res = new ArrayList<>();

        find(root, new StringBuilder(), res);

        int ans = 0;

        for(String n : res)
        {
            ans += Integer.parseInt(n, 2);
        }

        return ans;
    }
}