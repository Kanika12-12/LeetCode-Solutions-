class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] sums = new int[maxVal + 1];
        for (int num : nums) {
            sums[num] += num;
        }
      
        int rob1 = 0; 
        int rob2 = 0; 
        
        for (int sum : sums) {
            int current = Math.max(rob1 + sum, rob2);
            rob1 = rob2;
            rob2 = current;
        }
        
        return rob2;
    }
}