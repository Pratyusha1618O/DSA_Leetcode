class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int smax = -1;
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                smax = max;
                max = nums[i]; 
                index = i;
            }
            else if(nums[i] > smax){
                smax = nums[i];
            }
        }

        if(max >= 2*smax){
            return index;
        }else{
            return -1;
        }
    }
}