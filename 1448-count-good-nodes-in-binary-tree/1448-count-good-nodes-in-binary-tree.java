class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, 0, Integer.MIN_VALUE);
        
    }
    private int helper(TreeNode root, int ans, int curMax){
        if(root == null){
            return 0;
        }
        int rootAnswer = 0;
        if(root.val >= curMax){
            rootAnswer = 1;
            curMax = root.val;
        }
        int lans = helper(root.left, ans,curMax);
        int rans = helper(root.right, ans, curMax);
        return lans + rans + rootAnswer;

    }
}