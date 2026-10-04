class Solution {
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        
        return maxLen;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxLen = Math.max(maxLen, length);

        if (isLeft) {
            dfs(node.right, false, length + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, length + 1);
            dfs(node.right, false, 1);
        }
    }
}