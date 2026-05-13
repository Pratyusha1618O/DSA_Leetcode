class Solution {
    public int missingNumber(int[] nums) {

        //sort
        for(int i=0; i<nums.length-1; i++){
            for(int j=0; j<nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        // Find missing number
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        
        // If all positions are correct
        return nums.length;

    }
}