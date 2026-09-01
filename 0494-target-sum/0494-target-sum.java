import java.util.HashMap;
import java.util.Map;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1); 
        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}