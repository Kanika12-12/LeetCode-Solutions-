class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLength = 0;
        int count = 0;
        int n = nums.length;

        for(int right = 0; right < n; right++){
            if(nums[right] == 0){
                count++;
            }
            while(count > 1){
                if(nums[left] == 0){
                 count--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);

        }
        return maxLength;
       
        
    }
}