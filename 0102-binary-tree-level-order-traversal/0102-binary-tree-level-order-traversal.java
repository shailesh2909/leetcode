class Solution {

    public void find(TreeNode root, int level, List<List<Integer>> ans)
    {
        if(root == null) return;

        if(ans.size() == level)
            ans.add(new ArrayList<>());

        ans.get(level).add(root.val);

        find(root.left, level + 1, ans);
        find(root.right, level + 1, ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        find(root, 0, ans);
        return ans;
    }
}