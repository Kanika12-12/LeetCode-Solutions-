class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroes = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[nonZeroes];
                nums[nonZeroes] = nums[i];
                nums[i] = temp;
                nonZeroes++;
            }
        }
        
    }
}