class Solution {
    private int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, 1);

        findPathSum(root, targetSum, 0L, hm);
        return total;
    }

    private void findPathSum(TreeNode curr, int targetSum, long currentSum, HashMap<Long, Integer> hm) {
        if (curr == null) return;
        currentSum += curr.val;

        if (hm.containsKey(currentSum - targetSum)) {
            total += hm.get(currentSum - targetSum);
        }

        hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);

        findPathSum(curr.left, targetSum, currentSum, hm);
        findPathSum(curr.right, targetSum, currentSum, hm);

        hm.put(currentSum, hm.get(currentSum) - 1);
    }
}