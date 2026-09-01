class Solution {
    static boolean solve(int target, int[] nums, int index, Boolean[][] dp) {
        if (target == 0) {
            return true; }
        if (target < 0 || index >= nums.length){
            return false; }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        boolean includeAns = solve(target - nums[index], nums, index + 1, dp);
        boolean excludeAns = solve(target, nums, index + 1, dp);
        return dp[index][target] = includeAns || excludeAns; }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num; }
        if (sum % 2 != 0) {
            return false; }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return solve(target, nums, 0, dp);
    }
}